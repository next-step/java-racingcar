package com.cspark.nextstep.step21;

import java.util.Objects;

public class StringCalculation {

  public static int calculate(String sentence) {
    inputValidate(sentence);

    String[] values = sentence.split(" ");
    int result = toInt(values[0]);
    for (int i = 1; i < values.length; i += 2) {
      result = calculate(values[i], result, toInt(values[i + 1]));
    }

    return result;
  }

  private static void inputValidate(String sentence) {
    if (Objects.isNull(sentence) || sentence.trim().length() == 0) {
      throw new IllegalArgumentException("잘못된 입력값입니다.");
    }
  }

  private static Integer calculate(String operator, int first, int second) {
    if (operator.equals("+")) {
      return first + second;
    }

    if (operator.equals("-")) {
      return first - second;
    }

    if (operator.equals("*")) {
      return first * second;
    }

    if (operator.equals("/")) {
      return first / second;
    }

    throw new IllegalArgumentException("지원하지 않는 연산입니다.");
  }

  private static int toInt(String value) {
    return Integer.parseInt(value);
  }
}
