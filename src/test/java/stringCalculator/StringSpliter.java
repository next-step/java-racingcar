package stringCalculator;

/**
 * @author choijaeyong on 2021/03/07.
 * @project java-racingcar
 * @description
 */
public class StringSpliter {
  public static String[] split(String input) {
    if (input == null || "".equals(input))
      throw new IllegalArgumentException("input is null or empty");
    return input.split(" ");
  }

}
