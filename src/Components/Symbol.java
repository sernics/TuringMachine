package Components;

public class Symbol {
  private final String symbol_;

  public Symbol(String symbol) {
    this.symbol_ = symbol;
  }
  public String get() {
    return this.symbol_;
  }
  public boolean equals(Symbol other) {
    return this.symbol_.equals(other.get());
  }
  // to string
  public String toString() {
    return this.symbol_;
  }
}