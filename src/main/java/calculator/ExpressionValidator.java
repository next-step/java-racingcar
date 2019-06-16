package calculator;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class ExpressionValidator {


  public static void validate(String expression) {
    if (isBlankOrNull(expression)) {
      throw new IllegalArgumentException("식을 입력하세요");
    }
    if (!isAllowedCharacters(ExpressionParser.separateStringExpression(expression))) {
      throw new IllegalArgumentException("숫자와 사칙연산 기호만 입력가능합니다.");
    }
  }

  private static boolean isAllowedCharacters(String[] parsedExpression) {
    return Arrays.stream(parsedExpression)
        .allMatch(values -> Numbers.isNumber(values) || Operator.isOperator(values));

  }

  private static boolean isBlankOrNull(String expression) {
    return expression == null || "".equals(expression.trim());
  }

}
