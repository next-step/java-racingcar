package stringCalculator;

public class Calculator {

  public int calculate(String input) {
    if (input == null || "".equals(input))
      throw new IllegalArgumentException("input is null or empty");

    String[] numberAndOperation = input.split(" ");

    if (Operation.PLUS == Operation.ofCode(numberAndOperation[1]))
      return Integer.parseInt(numberAndOperation[0]) + Integer.parseInt(numberAndOperation[2]);

    if (Operation.MINUS == Operation.ofCode(numberAndOperation[1]))
      return Integer.parseInt(numberAndOperation[0]) - Integer.parseInt(numberAndOperation[2]);

    if (Operation.MULTIPLE == Operation.ofCode(numberAndOperation[1]))
      return Integer.parseInt(numberAndOperation[0]) * Integer.parseInt(numberAndOperation[2]);

    return Integer.parseInt(numberAndOperation[0]) / Integer.parseInt(numberAndOperation[2]);
  }

}
