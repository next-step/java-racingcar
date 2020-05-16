package chactercalculator;

import java.util.Arrays;

public enum Operator {

  PLUS("+") {
    @Override
    public Integer calculate(int first, int second) {
      return first + second;
    }
  },

  MINUS("-") {
    @Override
    public Integer calculate(int first, int second) {
      return first - second;
    }
  },

  MULTIPLY("*") {
    @Override
    public Integer calculate(int first, int second) {
      return first * second;
    }
  },

  DIVIDE("/") {
    @Override
    public Integer calculate(int first, int second) {
      if (second == 0) {
        throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
      }
      return first / second;
    }
  };

  private final String operator;

  private Operator(String operator) {
    this.operator = operator;
  }

  public abstract Integer calculate(int first, int second);

  public String getOperator() {
    return operator;
  }

  public static Operator findOperatorTypeByGivenOperator(String givenOperator) {
    return Arrays.stream(Operator.values())
        .filter(operatorType -> operatorType.getOperator().equals(givenOperator))
        .findFirst()
        .orElseThrow(IllegalArgumentException::new);
  }
}
