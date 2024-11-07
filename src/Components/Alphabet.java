package Components;

import java.util.LinkedHashSet;
import java.util.Set;

public class Alphabet {
  private final Set<Symbol> alphabet_;

  public Alphabet() {
    this.alphabet_ = new LinkedHashSet<>();
  }
  public void add(Symbol symbol) {
    this.alphabet_.add(symbol);
  }
  public Set<Symbol> getAlphabet() {
    return this.alphabet_;
  }
  public boolean contains(Symbol symbol) {
    // Comprobar el string
    for (Symbol s : this.alphabet_) {
      if (s.equals(symbol)) {
        return true;
      }
    }
    return false;
  }
  // to string
  public String toString() {
    StringBuilder result = new StringBuilder("Alphabet: ");
    for (Symbol symbol : this.alphabet_) {
      result.append(symbol.toString()).append(" ");
    }
    return result.toString();
  }
}