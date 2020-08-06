package com.cspark.nextstep.step21;

public class AdditionCalculator implements Calculable {

  @Override
  public boolean isSupport(String operator) {
    return operator.equals("+");
  }

  @Override
  public int calculate(int x, int y) {
    return x + y;
  }
}
