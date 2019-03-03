import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;

public class Calculator {
  static Stack<Number> stack = new Stack<Number>();
  static Scanner reader = new Scanner(System.in);

  public static void main(String[] args) {
    do {
      System.out.print("> ");
    } while (parseLine(reader.nextLine(), true));
  }

  private static boolean parseLine(String line, boolean print) {
    boolean keepRunning = true;

    String[] words = line.split(" ");
    for (String w : words) {
      Number number = new Number(w);
      if (number.isValid()) {
        stack.push(number);
        continue;
      }
      keepRunning = command(w);
      if (!keepRunning) break;
    }

    if (print) printStack();

    return keepRunning;
  }

  private static void printStack() {
    System.out.println();
    Object[] array = stack.toArray();
    for (int i = array.length - 1; i >= 0; i--)
      System.out.println("  " + array[i]);
    System.out.println();
  }

  private static boolean command(String s) { // returns T/F as to whether
    switch (s) {                             // the program should quit
    case "+": return pushTwoValueCommand((a, b) -> a + b);
    case "-": return pushTwoValueCommand((a, b) -> a - b);
    case "*": return pushTwoValueCommand((a, b) -> a * b);
    case "/": return pushTwoValueCommand((a, b) -> a / b);
    case "%": return pushTwoValueCommand((a, b) -> a % b);
    case "!":
      String newCommand = "";
      double n = stack.peek().value() - 1;
      for (double i = n; i > 0; --i) newCommand += "d 1 - -1 * ";
      for (double i = n; i > 0; --i) newCommand += "* ";
      parseLine(newCommand, false);
      return true;
    case "^": return pushTwoValueCommand((a, b) -> Math.pow(a, b));
    case "d": stack.push(stack.peek()); return true;
    case "c": stack.clear(); return true;
    case "q": return false;
    }
    return false;
  }

  private static boolean pushTwoValueCommand(TwoValueCommand command) {
    double a = stack.pop().value();
    double b = stack.pop().value();
    stack.push(new Number(command.calculate(a, b)));
    return true;
  }
}
