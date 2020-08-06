package com.cspark.nextstep.step21;

public class StringCalculation {

  public static int calculate(String sentence) {
    String[] values = sentence.split(" ");
    String operator = values[1];

    if (operator.equals("+")) {
      return toInt(values[0]) + toInt(values[2]);
    }

    if (operator.equals("-")) {
      return toInt(values[0]) - toInt(values[2]);
    }

    if (operator.equals("*")) {
      return toInt(values[0]) * toInt(values[2]);
    }

    return toInt(values[0]) / toInt(values[2]);
  }

  private static int toInt(String value) {
    return Integer.parseInt(value);
  }
}
