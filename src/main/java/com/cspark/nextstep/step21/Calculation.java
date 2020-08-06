package com.cspark.nextstep.step21;

import com.cspark.nextstep.step2.calculation.Calculator;
import java.util.Arrays;

public enum Calculation {

  ADD("+", (x, y) -> x + y),
  SUBTRACT("-", (x, y) -> x - y),
  MULTIPLY("*", (x, y) -> x * y),
  DIVIDE("/", (x, y) -> x / y);

  private String operator;
  private Calculator calculator;

  Calculation(String operator, Calculator calculator) {
    this.operator = operator;
    this.calculator = calculator;
  }

  public static Calculation of(String operator) {
    return Arrays.stream(values())
        .filter(calculation -> calculation.isSupport(operator))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 연산입니다."));
  }

  private boolean isSupport(String operator) {
    return this.operator.equals(operator);
  }

  public int calculate(int first, int second) {
    return calculator.calculate(first, second);
  }

}
