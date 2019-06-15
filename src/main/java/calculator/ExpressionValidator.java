package calculator;

public class ExpressionValidator {


  public static void validate(String expression) {
    if (expression == null || "".equals(expression.trim())) {
      throw new IllegalArgumentException("식을 입력하세요");
    }
  }
}
