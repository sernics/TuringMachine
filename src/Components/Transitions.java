package Components;

public record Transitions(State actualState, Symbol readSymbol, State nextState, Symbol writeSymbol,
                          Direction direction) {
  public String toString() {
    return "Transition: " + this.actualState + " " + this.readSymbol + " " + this.nextState + " "
      + this.writeSymbol + " " + this.direction;
  }
}