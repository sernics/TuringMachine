import Components.TuringMachine;

public class Main {
  public static void main(String[] args) {
    System.out.println("Turing Machine Simulator");
    Parser parser = new Parser("./examples/ejercicio2.txt");
    TuringMachine tm = parser.parse();
    System.out.println(tm.run("abbabaabb"));
  }
}