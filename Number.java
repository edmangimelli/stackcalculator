import java.util.Stack;

public class Number {
  private double value;
  private boolean valid;

  public Number(String s) {
    try {
      value = Float.parseFloat(s);
      valid = true;
    } catch(Exception e) {
      valid = false;
    }
  }

  public Number(double d) {
    value = d;
    valid = true;
  }

  public double value() {return value;}
  public boolean isValid() {return valid;}
  public String toString() {
    String s = Double.toString(value);
    int neg2 = s.length() - 2;
    if (s.substring(neg2).equals(".0"))
      return s.substring(0, neg2);
    return s;
  }

}
