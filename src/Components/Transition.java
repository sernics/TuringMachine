package Components;

public record Transition(Symbol readSymbol, State nextState, Symbol writeSymbol,
                          Direction direction) {
  public String toString() {
    return "Transition: " + this.readSymbol + " " + this.nextState + " "
      + this.writeSymbol + " " + this.direction;
  }
}