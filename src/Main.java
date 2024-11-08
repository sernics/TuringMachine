import Components.TuringMachine;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    System.out.println("Turing Machine Simulator");
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the file to read the Turing Machine: ");
    String path = "./examples/" + scanner.nextLine();
    Parser parser = new Parser(path);
    TuringMachine tm = parser.parse();
    String chain = "";
    while (true) {
      System.out.print("Enter a chain to test the Turing Machine (exit to close): ");
      chain = scanner.nextLine();
      if (!chain.equals("exit")) {
        tm.run(chain);
        System.out.println("===========================================================================");
      } else {
        System.out.println("Exiting...");
        break;
      }
    }
    scanner.close();
  }
}