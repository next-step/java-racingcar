package calculator;

import java.util.HashMap;
import java.util.Map;

public abstract class Operator {

  private final String operator;
  private static final Map<String, Operator> operatorMap = new HashMap<>();

  private Operator(String operator) {
    this.operator = operator;
    operatorMap.put(this.operator, this);
  }

  abstract int calculate(int operand1, int operand2);

  public static Operator PLUS = new Operator("+") {
    @Override
    int calculate(int operand1, int operand2) {
      return operand1 + operand2;
    }
  };

  public static Operator MINUS = new Operator("-") {
    @Override
    int calculate(int operand1, int operand2) {
      return operand1 - operand2;
    }
  };

  public static Operator MULTIPLY = new Operator("*") {
    @Override
    int calculate(int operand1, int operand2) {
      return operand1 * operand2;
    }
  };

  public static Operator DIVIDE = new Operator("/") {
    @Override
    int calculate(int operand1, int operand2) {
      return operand1 / operand2;
    }
  };

  public static Operator get(String operator) {
    if (!StringValidator.isOperator(operator)) {
      throw new IllegalArgumentException("[Operator Exception] '" + operator + "' 는 사칙 연산자가 아닙니다.");
    }
    return operatorMap.get(operator);
  }

}
