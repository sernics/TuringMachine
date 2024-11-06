import java.util.Objects;
import java.util.Scanner;
import java.util.Vector;

import Components.*;

public class Parser {
  private final String fileName_;
  private Vector<String[]> generateVectorData(String filename) {
    Vector<String[]> data = new Vector<>();
    try {
      Scanner scanner = new Scanner(new java.io.File(filename));
      while (scanner.hasNextLine()) {
        String line = this.removeComments(scanner.nextLine());
        if (line.isEmpty()) continue;
        String[] tokens = line.split("\\s+");
        data.add(tokens);
      }
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
    return data;
  }
  private String removeComments(String line) {
    return line.split("#")[0];
  }
  private Vector<State> generateStates(String[] data) {
    Vector<State> states = new Vector<>();
    for (String state : data) {
      states.add(new State(state));
    }
    return states;
  }
  private Alphabet generateAlphabet(String[] data) {
    Alphabet alphabet = new Alphabet();
    for (String symbol : data) {
      alphabet.add(new Symbol(symbol));
    }
    return alphabet;
  }
  private State getInitialState(Vector<State> states, String initialState) {
    for (State state : states) {
      if (state.getId().equals(initialState)) {
        return state;
      }
    }
    return null;
  }
  private void setFinalStates(Vector<State> states, String[] finalStates) {
    for (String finalState : finalStates) {
      boolean found = false;
      for (State state : states) {
        if (state.getId().equals(finalState)) {
          state.setFinal();
          found = true;
          break;
        }
      }
      if (!found) {
        System.err.println("Error: Final state " + finalState + " not found");
      }
    }
  }
  private State searchState(String stateId, Vector<State> states) {
    for (State state : states) {
      if (state.getId().equals(stateId)) {
        return state;
      }
    }
    return null;
  }
  public Parser(String fileName) {
    this.fileName_ = fileName;
  }
  public TuringMachine parse() {
    Vector<String[]> data = this.generateVectorData(this.fileName_);
    Vector<State> states = generateStates(data.getFirst());
    Alphabet alphabet = generateAlphabet(data.get(1));
    Alphabet tapeAlphabet = generateAlphabet(data.get(2));
    State initialState = getInitialState(states, data.get(3)[0]);
    if (initialState == null) {
      System.err.println("Error: Initial state not found");
    }
    Symbol blankSymbol = new Symbol(data.get(4)[0]);
    this.setFinalStates(states, data.get(5));
    int i = 6;
    while (i < data.size()) {
      String[] transitionData = data.get(i);
      State fromState = this.searchState(transitionData[0], states);
      if (fromState == null) {
        System.err.println("Error: State " + transitionData[0] + " not found");
      }
      Symbol readSymbol = new Symbol(transitionData[1]);
      State toState = this.searchState(transitionData[2], states);
      if (toState == null) {
        System.err.println("Error: State " + transitionData[2] + " not found");
      }
      Symbol writeSymbol = new Symbol(transitionData[3]);
      Direction direction = new Direction(transitionData[4]);
      Transition transition = new Transition(readSymbol, toState, writeSymbol, direction);
      Objects.requireNonNull(fromState).addTransition(transition);
      i++;
    }
    return new TuringMachine(states, alphabet, tapeAlphabet, initialState, blankSymbol);
  }
}
