package Components;

import java.util.Vector;

public class TuringMachine {
  private final Vector<State> states_;
  private final Alphabet alphabet_;
  private final Alphabet tapeAlphabet_;
  private final State initialState_;
  private final Symbol blankSymbol_;
  private final Tape tape_;
  private boolean checkChain(String chain) {
    for (String symbol : chain.split("")) {
      if (!this.alphabet_.contains(new Symbol(symbol))) {
        return false;
      }
    }
    return true;
  }
  private State transitionFunction(State currentState) {
    Vector<Transition> transitions = currentState.getTransitions();
    Symbol actualSymbol = this.tape_.read();
    for (Transition transition : transitions) {
      if (transition.readSymbol().equals(actualSymbol)) {
        this.tape_.write(transition.writeSymbol());
        transition.direction().operate(tape_);
        return transition.nextState();
      }
    }
    return null;
  }

  public TuringMachine(Vector<State> states, Alphabet alphabet, Alphabet tapeAlphabet, State initialState, Symbol blankSymbol) {
    this.states_ = states;
    this.alphabet_ = alphabet;
    this.tapeAlphabet_ = tapeAlphabet;
    this.initialState_ = initialState;
    this.blankSymbol_ = blankSymbol;
    this.tape_ = new Tape(blankSymbol);
  }
  public boolean run(String chain) {
    if (!this.checkChain(chain)) {
      System.err.println("The chain contains symbols not in the alphabet");
      return false;
    }
    tape_.setChain(chain);
    State currentState = this.initialState_;
    while (true) {
      currentState = transitionFunction(currentState);
      if (currentState == null) {
        System.out.println(tape_);
        break;
      }
      if (currentState.isFinal()) {
        System.out.println("The result is: " + tape_);
        return true;
      }
    }
    return false;
  }
  public String toString() {
    StringBuilder result = new StringBuilder("States:\n");
    for (State state : this.states_) {
      result.append(state.toString()).append("\n");
      result.append("Transitions: ").append(state.getTransitions()).append("\n");
    }
    result.append("Alphabet: ").append(this.alphabet_.toString()).append("\n");
    result.append("Tape Alphabet: ").append(this.tapeAlphabet_.toString()).append("\n");
    result.append("Initial State: ").append(this.initialState_.toString()).append("\n");
    result.append("Blank Symbol: ").append(this.blankSymbol_.toString()).append("\n");
    return result.toString();
  }
}
