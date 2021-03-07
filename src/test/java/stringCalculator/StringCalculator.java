package stringCalculator;

/**
 * @author choijaeyong on 2021/03/07.
 * @project java-racingcar
 * @description
 */
public class StringCalculator {

  public int calculate(String input) {
    String[] strs = StringSpliter.split(input);
    Calculator calculator = new Calculator();
    return calculator.calculate(strs);
  }

}
