package camp.nextstep.racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.regex.Pattern;

public class Calculator {

  final private Pattern INVALID_INPUT_PATTERN = Pattern.compile(".*[^0-9+\\-*/ ]+.*");
  final private Pattern NUMBERS_PATTERN = Pattern.compile("[0-9]+");
  final private Pattern OPERATOR_PATTERN = Pattern.compile("[+\\-*/ ]");
  final private String TOKEN_DELIMITER = " ";

  public static int add(int a, int b) {
    return a + b;
  }

  public static int subtract(int a, int b) {
    return a - b;
  }

  public static int multiply(int a, int b) {
    return a * b;
  }

  public static int divide(int a, int b) {
    return a / b;
  }

  private boolean isIllegalInput(String input) {
    return input == null || input.isEmpty() || INVALID_INPUT_PATTERN.matcher(input).matches();
  }

  private boolean isNumberToken(String token) {
    return NUMBERS_PATTERN.matcher(token).matches();
  }

  private boolean isOperatorToken(String token) {
    return OPERATOR_PATTERN.matcher(token).matches();
  }

  private BiFunction<Integer, Integer, Integer> getOperateFunction(String operator) {
    BiFunction<Integer, Integer, Integer> operate = null;
    if (operator.equals("+")) {
      operate = Calculator::add;
    } else if (operator.equals("-")) {
      operate = Calculator::subtract;
    } else if (operator.equals("*")) {
      operate = Calculator::multiply;
    } else if (operator.equals("/")) {
      operate = Calculator::divide;
    }
    if (operate == null) {
      throw new IllegalArgumentException();
    }
    return operate;
  }

  public List<String> tokenizer(String input) {
    if (isIllegalInput(input)) {
      throw new IllegalArgumentException();
    }
    return new ArrayList<>(Arrays.asList(input.split(TOKEN_DELIMITER)));
  }

  private int calculate(List<String> tokens) {
    Integer accumulator = null;
    BiFunction<Integer, Integer, Integer> currentOperateFunction = null;

    for (String token : tokens) {
      if (accumulator == null) {
        accumulator = Integer.parseInt(token);
      } else if (isOperatorToken(token)) {
        currentOperateFunction = getOperateFunction(token);
      } else if (isNumberToken(token)) {
        accumulator = Objects.requireNonNull(currentOperateFunction).apply(accumulator, Integer.parseInt(token));
      }
    }

    return accumulator;
  }

  public int calculate(String expression) {
    return calculate(tokenizer(expression));
  }
}
