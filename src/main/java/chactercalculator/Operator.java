package chactercalculator;

import java.util.Arrays;

public enum Operation {

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

  private Operation(String operator) {
    this.operator = operator;
  }

  public abstract Integer calculate(int first, int second);

  public String getOperator() {
    return operator;
  }

  public Operation findOperatorByGivenSign(String sign) {
    return Arrays.stream(Op)
  }
}
