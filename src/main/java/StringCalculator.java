public class StringCalculator {

  public int calculate(String str) {
    if (str == null || str.equals("")) {
      return 0;
    }
    return Integer.parseInt(str);
  }
}
