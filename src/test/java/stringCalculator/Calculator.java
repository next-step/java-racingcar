package stringCalculator;

public class Calculator {

  public int calculate(String input) {
    if (input == null || "".equals(input))
      throw new IllegalArgumentException("input is null or empty");

    String[] strs = input.split(" ");
    Integer result = Integer.valueOf(strs[0]);
    for (int i=0 ; i+2 < strs.length ; i = i+2) {
      result = twoNumberCalculate(result, strs[i + 1], Integer.parseInt(strs[i + 2]));
    }
    return result;
  }

  private int twoNumberCalculate(Integer firstNumber, String operation, Integer secondNumber) {
    if (Operation.PLUS == Operation.ofCode(operation))
      return firstNumber + secondNumber;

    if (Operation.MINUS == Operation.ofCode(operation))
      return firstNumber - secondNumber;

    if (Operation.MULTIPLE == Operation.ofCode(operation))
      return firstNumber * secondNumber;

    return firstNumber / secondNumber;

  }

}