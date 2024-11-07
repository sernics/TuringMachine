package Components;

import java.util.ArrayList;

public class Tape {
  private final ArrayList<Symbol> tape_ = new ArrayList<>();
  private int head_ = 0;
  private final Symbol blankSymbol_;
  public Tape(Symbol blankSymbol) {
    this.blankSymbol_ = blankSymbol;
    this.tape_.add(blankSymbol_);
  }
  public void setChain(String chain) {
    for (String symbol : chain.split("")) {
      this.tape_.add(new Symbol(symbol));
    }
    this.tape_.add(blankSymbol_);
    this.head_ = 1;
  }
  public void moveHeadLeft() {
    if (this.head_ == 0) {
      this.tape_.addFirst(blankSymbol_);
    } else {
      this.head_--;
    }
  }
  public void moveHeadRight() {
    if (this.head_ == this.tape_.size() - 1) {
      this.tape_.add(blankSymbol_);
    }
    this.head_++;
  }
  public void write(Symbol symbol) {
    this.tape_.set(this.head_, symbol);
  }
  public Symbol read() {
    return this.tape_.get(this.head_);
  }
  public String toString() {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < this.tape_.size(); i++) {
      if (i == this.head_) {
        result.append("[").append(this.tape_.get(i).toString()).append("]");
      } else {
        result.append(this.tape_.get(i).toString());
      }
    }
    return result.toString();
  }
}
