package calculator;

public class Calculator {

  public Calculator() {
  }

  public int calculate(String targetString) {
    int targetNumber = Integer.parseInt(targetString);
    checkMinus(targetNumber);
    return targetNumber;
  }

  private void checkMinus(int targetNumber) {
    if (targetNumber < 0) {
      throw new RuntimeException();
    }
  }

}
