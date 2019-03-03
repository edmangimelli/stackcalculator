import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;

public class Calculator {
  static Stack<Float> stack = new Stack<Float>();
  static Scanner reader = new Scanner(System.in);

  public static void main(String[] args) {
    do {
      System.out.print("> ");
    } while (parseLine(reader.nextLine(), true));
  }

  public static boolean command(String s) {     // returns T/F as to whether
    TwoValueCommand addition = (a, b) -> a + b; // the program should quit
    TwoValueCommand subtraction = (a, b) -> a - b;
    TwoValueCommand multiplication = (a, b) -> a * b;
    TwoValueCommand division = (a, b) -> a / b;
    TwoValueCommand modulo = (a, b) -> a % b;
    switch (s) {
    case "+": return pushTwoValueCommand(addition);
    case "-": return pushTwoValueCommand(subtraction);
    case "*": return pushTwoValueCommand(multiplication);
    case "/": return pushTwoValueCommand(division);
    case "%": return pushTwoValueCommand(subtraction);
    case "!":
      String newCommand = "";
      float n = stack.peek() - 1;
      for (float i = n; i > 0; --i) newCommand += "d 1 - -1 * ";
      for (float i = n; i > 0; --i) newCommand += "* ";
      parseLine(newCommand, false);
      return true;
    case "d": stack.push(stack.peek()); return true;
    case "c": stack.clear(); return true;
    case "q": return false;
    }
    return false;
  }

  public static boolean pushTwoValueCommand(TwoValueCommand command) {
    float a = stack.pop();
    float b = stack.pop();
    stack.push(command.calculate(a, b));
    return true;
  }

  public static String numberToString(Object o) {
    String s = Float.toString((float)o);
    int neg2 = s.length() - 2;
    if (s.substring(neg2).equals(".0"))
      return s.substring(0, neg2);
    return s;
  }

  public static boolean parseLine(String line, boolean printStack) {
    boolean keepRunning = true;
    String[] words = line.split(" ");
    for (String w : words) {
      Number number = new Number(w);
      if (number.isValid()) {
        stack.push(number.value());
        continue;
      }
      keepRunning = command(w);
      if (!keepRunning) break;
    }

    if (!printStack) return keepRunning;

    System.out.println();
    Object[] array = stack.toArray();
    for (int i = array.length - 1; i >= 0; i--)
      System.out.println("  " + numberToString(array[i]));
    System.out.println();
    return keepRunning;
  }
}
