import Components.TuringMachine;

public class Main {
  public static void main(String[] args) {
    Parser parser = new Parser("./examples/ejercicio1.txt");
    TuringMachine tm = parser.parse();
    System.out.println(tm.run("b"));
  }
}