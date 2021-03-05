package calculator;

public enum Operator {
  ADD("+"),
  SUB("-"),
  MUL("*"),
  DIV("/");

  private final String operator;

  Operator(String operator) {
    this.operator = operator;
  }

  private String getOperator() {
    return operator;
  }

  public static int operate(int firstVal, int secondVal, String operator) {
    if (operator.equals(ADD.getOperator())) {
      return firstVal + secondVal;
    }
    if (operator.equals(SUB.getOperator())) {
      return firstVal - secondVal;
    }
    if (operator.equals(MUL.getOperator())) {
      return firstVal * secondVal;
    }
    if (operator.equals(DIV.getOperator())) {
      return firstVal / secondVal;
    }
    throw new IllegalArgumentException("사칙 연산 기호가 아닙니다.");
  }

}
