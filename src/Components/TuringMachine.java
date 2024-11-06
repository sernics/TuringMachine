package Components;

import java.util.Vector;

public class TuringMachine {
  private final Vector<State> states_;
  private final Alphabet alphabet_;
  private final Alphabet tapeAlphabet_;
  private final State initialState_;
  private final Symbol blankSymbol_;
  public TuringMachine(Vector<State> states, Alphabet alphabet, Alphabet tapeAlphabet, State initialState, Symbol blankSymbol) {
    this.states_ = states;
    this.alphabet_ = alphabet;
    this.tapeAlphabet_ = tapeAlphabet;
    this.initialState_ = initialState;
    this.blankSymbol_ = blankSymbol;
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
