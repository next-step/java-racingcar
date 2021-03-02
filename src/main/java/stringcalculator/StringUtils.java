package stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {

  public static final String DELIMITER = " ";

  private StringUtils() {
  }

  public static boolean isBlankString(String string) {
    return string == null || string.trim().isEmpty();
  }

  public static String[] split(String expression) {
    return expression.split(DELIMITER);
  }

  public static List<Integer> extractNumbers(String expression) {
    return Arrays.stream(split(expression))
        .filter(StringUtils::isInteger)
        .map(Integer::valueOf)
        .collect(Collectors.toList());
  }

  public static List<Operator> extractOperators(String expression) {
    return Arrays.stream(split(expression))
        .filter(StringUtils::isOperator)
        .map(Operator::operatorOf)
        .collect(Collectors.toList());
  }

  public static boolean isInteger(String token) {
    try {
      Integer.parseInt(token);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  public static boolean isOperator(String token) {
    try {
      Operator.operatorOf(token);
      return true;
    } catch (IllegalArgumentException e) {
      return false;
    }
  }
}
