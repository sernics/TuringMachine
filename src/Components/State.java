package Components;

import java.util.Vector;

public class State {
  private final String id_;
  private boolean isFinal_ = false;
  private final Vector<Transition> transitionsVector = new Vector<>();

  public State(String id) {
    this.id_ = id;
  }
  public String getId() {
    return this.id_;
  }
  public boolean isFinal() {
    return this.isFinal_;
  }
  public void setFinal() {
    this.isFinal_ = true;
  }
  public void addTransition(Transition transition) {
    this.transitionsVector.add(transition);
  }
  public Vector<Transition> getTransitions() {
    return this.transitionsVector;
  }
  public String toString() {
    return "State: " + this.id_ + (this.isFinal_ ? " (final)" : "");
  }
}
