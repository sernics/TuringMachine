import Components.TuringMachine;

public class Main {
  public static void main(String[] args) {
    Parser parser = new Parser("./examples/Ejemplo2_MT.txt");
    TuringMachine tm = parser.parse();
    System.out.println(tm.run("111111"));
  }
}