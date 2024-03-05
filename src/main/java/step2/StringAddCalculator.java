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

    // deriveAdditionalDelimiter 안에서 expression 까지 잘라서 주는건 좀 위험?
    String additionalDelimiter = deriveAdditionalDelimiter(expression);
    this.delimiters.add(additionalDelimiter);
    // 없앨 수 없을까...
    if (additionalDelimiter != null) {
      expression = expression.substring(4);
    }

    return this.delimit(expression).stream().reduce(0, Integer::sum);
  }

  private List<Integer> delimit(String expression) {
    List<String> tokens = List.of(expression);

    for (String delimiter : this.delimiters) {
      List<String> temp = new LinkedList<>();

      for (String token : tokens) {
        temp.addAll(List.of(token.split(delimiter)));
      }

      tokens = temp;
    }

    return tokens.stream().map(Integer::parseUnsignedInt).collect(Collectors.toList());
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
}
