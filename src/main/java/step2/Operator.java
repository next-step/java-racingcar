package step2;

import java.util.function.BiFunction;

public enum Operator {
  ADD("+", (num1, num2) -> num1 + num2),
  SUBTRACT("-", (num1, num2) -> num1 - num2),
  MULTIPLY("*", (num1, num2) -> num1 * num2),
  DIVIDE("/", (num1, num2) -> {
    if (num2 == 0) {
      throw new ArithmeticException("0으로 나눌 수 없습니다.");
    }
    return num1 / num2;
  });
  
  private String operator;
  private BiFunction<Integer, Integer, Integer> calculation;
  
  Operator(String operator, BiFunction<Integer, Integer, Integer> calculation) {
    this.operator = operator;
    this.calculation = calculation;
  }
  
  public String getOperator() {
    return operator;
  }
  
  public BiFunction<Integer, Integer, Integer> getCalculation() {
    return calculation;
  }
  
  public static Operator convertOperator(String strOperator) {
    for (Operator operator : values()){
      if (operator.getOperator().equalsIgnoreCase(strOperator)) {
        return operator;
      }
    }
    throw new IllegalArgumentException("잘못된 연산자 입니다.");
  }
  
  public static int calculation(String operator, int total, int num) {
    return convertOperator(operator).getCalculation().apply(total, num);
  }
}
