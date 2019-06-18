package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Operator {

  private static final int PEEK_OPERATOR_INDEX = 0;
  private List<String> operators;

  public Operator(String[] operators) {

    this.operators = separateOperator(operators);
  }

  private List<String> separateOperator(String[] separatedExpression) {
    return Arrays.stream(separatedExpression)
        .filter(value -> OperatorType.isOperator(value))
        .collect(Collectors.toList());
  }

  public String getOperator() {
    String operator = operators.get(PEEK_OPERATOR_INDEX);
    operators.remove(PEEK_OPERATOR_INDEX);
    return operator;
  }

  public int calculate(int leftValue, int rightValue) {
    return OperatorType.calculate(getOperator(), leftValue, rightValue);
  }

  public static boolean isOperator(String value) {
    return OperatorType.isOperator(value);
  }
}
