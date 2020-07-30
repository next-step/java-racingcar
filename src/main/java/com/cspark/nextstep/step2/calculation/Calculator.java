package com.cspark.nextstep.step2.calculation;

import java.util.function.BiFunction;

public abstract class Calculator {

  private BiFunction<Integer, Integer, Integer> operator;

  public Calculator(BiFunction<Integer, Integer, Integer> operator) {
    this.operator = operator;
  }

  public Integer calculate(int x, int y) {
    return operator.apply(x, y);
  }

}
