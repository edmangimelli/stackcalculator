import java.util.Stack;

public class Number {
  private float value;
  private boolean valid;

  public Number(String s) {
    try {
      value = Float.parseFloat(s);
      valid = true;
    } catch(Exception e) {
      valid = false;
    }
  }

  public float value() {return value;}
  public boolean isValid() {return valid;}
}
