package step2;

import java.util.*;
import java.util.stream.Collectors;

public class StringAddCalculator {
  private final Delimiters delimiters;

  public StringAddCalculator() {
    List<String> delimiters = new ArrayList<>();
    delimiters.add(",");
    delimiters.add(":");
    this.delimiters = new Delimiters(delimiters);
  }

  public Integer calculate(String expression) {
    if (expression == null || expression.trim().equals("")) {
      return 0;
    }

    String additionalDelimiter = deriveAdditionalDelimiter(expression);
    this.delimiters.add(additionalDelimiter);
    expression = trimAdditionalDelimiter(expression, additionalDelimiter);

    return this.delimit(expression).stream().reduce(0, Integer::sum);
  }

  private List<Integer> delimit(String expression) {
    String[] tokenized = expression.split(this.delimiters.getCombinedDelimiter());
    return Arrays.stream(tokenized).map(Integer::parseUnsignedInt).collect(Collectors.toList());
  }

  private String deriveAdditionalDelimiter(String expression) {
    if (expression.length() < 4) {
      return null;
    }

    if ("//".equals(expression.substring(0, 2)) && "\n".equals(expression.substring(3, 4))) {
      return String.valueOf(expression.substring(0, 4).charAt(2));
    }

    return null;
  }

  private String trimAdditionalDelimiter(String origin, String additionalDelimiter) {
    if (additionalDelimiter != null) {
      return origin.substring(4);
    }
    return origin;
  }
}
