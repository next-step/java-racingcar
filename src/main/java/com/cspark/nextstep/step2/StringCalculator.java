package com.cspark.nextstep.step2;

import java.util.Objects;

public class StringCalculator {

  public static int calculate(String sentenceAsString) {
    if (isBlank(sentenceAsString)) {
      throw new IllegalArgumentException();
    }

    String newSentenceAsString = "+ " + sentenceAsString;
    String[] pieces = newSentenceAsString.split(" ");
    int result = 0;
    for (int i = 0; i < pieces.length; i = i + 2) {
      if (pieces[i].equals("+")) {
        result += Integer.parseInt(pieces[i + 1]);
      } else if (pieces[i].equals("-")) {
        result -= Integer.parseInt(pieces[i + 1]);
      } else if (pieces[i].equals("*")) {
        result *= Integer.parseInt(pieces[i + 1]);
      } else if (pieces[i].equals("/")) {
        result /= Integer.parseInt(pieces[i + 1]);
      } else {
        throw new IllegalArgumentException();
      }
    }

    return result;
  }

  private static boolean isBlank(String express) {
    return Objects.isNull(express) || express.trim().isEmpty();
  }

}
