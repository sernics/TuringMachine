package Components;

public class LeftDirection implements Direction {
  public void operate(Tape tape) {
    tape.moveHeadLeft();
    System.out.println(tape);
  }
}
