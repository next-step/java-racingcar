package stringCalculator;

public class Calculator {

  public int calculate(String[] strs) {
    Integer result = Integer.valueOf(strs[0]);
    for (int i=0 ; i+2 < strs.length ; i = i+2) {
      result = calculate(result, strs[i + 1], Integer.parseInt(strs[i + 2]));
    }
    return result;
  }

  private int calculate(Integer firstNumber, String operation, Integer secondNumber) {
    if (Operation.PLUS == Operation.ofCode(operation))
      return firstNumber + secondNumber;

    if (Operation.MINUS == Operation.ofCode(operation))
      return firstNumber - secondNumber;

    if (Operation.MULTIPLE == Operation.ofCode(operation))
      return firstNumber * secondNumber;

    if (secondNumber == 0) {
      throw new IllegalArgumentException("0으로 나눗셈은 불가능 합니다.");
    }

    return firstNumber / secondNumber;

  }

}