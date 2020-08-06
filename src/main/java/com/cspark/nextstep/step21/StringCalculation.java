package com.cspark.nextstep.step21;

import java.util.Objects;

public class StringCalculation {

  public static int calculate(String sentence) {
    if (Objects.isNull(sentence) || sentence.trim().length() == 0) {
      throw new IllegalArgumentException("잘못된 입력값입니다.");
    }

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

    if (operator.equals("/")) {
      return toInt(values[0]) / toInt(values[2]);
    }

    throw new IllegalArgumentException("지원하지 않는 연산입니다.");
  }

  private static int toInt(String value) {
    return Integer.parseInt(value);
  }
}
