package calculator;

public class ExpressionValidator {

  public static void validate(String expression) {
    isEmpty(expression);
    String[] expressionElements = expression.split(" ");
    isNumberStarted(expressionElements);
    isNumberEnded(expressionElements);
    isOddElements(expressionElements);
    isRepeatNumberOperator(expressionElements);
  }

  private static void isEmpty(String expression) {
    if (StringValidator.isBlank(expression)) {
      throw new IllegalArgumentException("수식은 null 이거나 빈칸일 수 없습니다.");
    }
  }

  private static void isRepeatNumberOperator(String[] expressionElements) {
    int lastIndex = expressionElements.length - 1;
    for (int i = 0; i <= lastIndex; i += 2) {
      String checkingElement = expressionElements[i];
      if (!NumberValidator.isNumber(checkingElement)) {
        throw new IllegalArgumentException("숫자 위치에 잘못된 값이 있습니다. 값 : " + checkingElement);
      }
    }
    for (int i = 1; i <= lastIndex; i += 2) {
      String checkingElement = expressionElements[i];
      if (!StringValidator.isOperator(checkingElement)) {
        throw new IllegalArgumentException("연산자 위치에 잘못된 값이 있습니다. 값 : " + checkingElement);
      }
    }
  }

  private static void isNumberStarted(String[] expressionElements) {
    if (!NumberValidator.isNumber(expressionElements[0])) {
      throw new IllegalArgumentException(
          "수식은 연산자로 시작할 수 없습니다. 값 : " + expressionElements[0]
      );
    }
  }

  private static void isNumberEnded(String[] expressionElements) {
    int lastIndex = expressionElements.length - 1;
    if (!NumberValidator.isNumber(expressionElements[lastIndex])) {
      throw new IllegalArgumentException(
          "수식은 연산자로 종료될 수 없습니다. 값 : " + expressionElements[lastIndex]
      );
    }
  }

  private static void isOddElements(String[] expressionElements) {
    if (expressionElements.length % 2 == 0) {
      throw new IllegalArgumentException("잘못된 수식입니다");
    }
  }

}
