package com.cspark.nextstep.step2;

import com.cspark.nextstep.step2.calculation.Calculator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class StringCalculator {

  private static final Map<String, Calculator> operators = new HashMap<>();

  static {
    operators.put("+", (x, y) -> x + y);
    operators.put("-", (x, y) -> x - y);
    operators.put("*", (x, y) -> x * y);
    operators.put("/", (x, y) -> x / y);
  }

  public static int calculate(String sentenceAsString) {
    if (isBlank(sentenceAsString)) {
      throw new IllegalArgumentException();
    }

    String[] pieces = sentenceAsString.split(" ");
    int result = toInt(pieces[0]);
    for (int i = 1; i < pieces.length; i += 2) {
      Calculator calculator = operators.get(pieces[i]);
      if (calculator == null) {
        throw new IllegalArgumentException();
      }

      result = calculator.calculate(result, toInt(pieces[i + 1]));
    }

    return result;
  }

  private static int toInt(String piece) {
    return Integer.parseInt(piece);
  }

  private static boolean isBlank(String express) {
    return Objects.isNull(express) || express.trim().isEmpty();
  }

}