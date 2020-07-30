package com.cspark.nextstep.step2;

import com.cspark.nextstep.step2.calculation.Addition;
import com.cspark.nextstep.step2.calculation.Calculator;
import com.cspark.nextstep.step2.calculation.Division;
import com.cspark.nextstep.step2.calculation.Multiplication;
import com.cspark.nextstep.step2.calculation.Subtraction;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class StringCalculator {

  private static final Map<String, Calculator> operators = new HashMap<>();

  static {
    operators.put("+", new Addition());
    operators.put("-", new Subtraction());
    operators.put("*", new Multiplication());
    operators.put("/", new Division());
  }

  public static int calculate(String sentenceAsString) {
    if (isBlank(sentenceAsString)) {
      throw new IllegalArgumentException();
    }

    String newSentenceAsString = "+ " + sentenceAsString;
    String[] pieces = newSentenceAsString.split(" ");
    int result = 0;
    for (int i = 0; i < pieces.length; i = i + 2) {
      Calculator calculator = operators.get(pieces[i]);
      if (calculator ==null) {
        throw new IllegalArgumentException();
      }

      result = calculator.calculate(result, Integer.parseInt(pieces[i + 1]));
    }

    return result;
  }

  private static boolean isBlank(String express) {
    return Objects.isNull(express) || express.trim().isEmpty();
  }

}





