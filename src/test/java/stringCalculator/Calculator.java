package stringCalculator;

/**
 * @author choijaeyong on 2021/03/04.
 * @project java-racingcar
 * @description
 */
public class Calculator {

  public int calculate(String input) {
    if (input == null)
      throw new IllegalArgumentException("input is empty");

    String[] numberAndOperation = input.split(" ");
    if ("+".equals(numberAndOperation[1]))
      return Integer.parseInt(numberAndOperation[0]) + Integer.parseInt(numberAndOperation[2]);

    if ("-".equals(numberAndOperation[1]))
      return Integer.parseInt(numberAndOperation[0]) - Integer.parseInt(numberAndOperation[2]);

    if ("*".equals(numberAndOperation[1]))
      return Integer.parseInt(numberAndOperation[0]) * Integer.parseInt(numberAndOperation[2]);

    return Integer.parseInt(numberAndOperation[0]) / Integer.parseInt(numberAndOperation[2]);
  }

}
