package Components;

public class RightDirection implements Direction {
  public void operate(Tape tape) {
    tape.moveHeadRight();
    // System.out.println(tape);
  }
}
