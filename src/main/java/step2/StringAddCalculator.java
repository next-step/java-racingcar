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
    if (expression == null || expression.trim().isEmpty()) {
      return 0;
    }

    Map<String, String> derivedMap = deriveAdditionalDelimiter(expression);
    this.delimiters.add(derivedMap.get("delimiter"));

    /* #1
    return this.delimit(derivedMap.get("expression")).stream()
            .reduce(0, (a, b) -> b.sumInt(a), Integer::sum);

    /* #2
    return this.delimit(derivedMap.get("expression")).stream()
            .reduce(new PositiveInteger(0), PositiveInteger::sum).getValue();

     */

    // #3
    return this.delimit(derivedMap.get("expression")).stream()
            .reduce(new PositiveInteger(0), PositiveInteger::add).getValue();
  }

  private List<PositiveInteger> delimit(String expression) {
    String[] tokenized = expression.split(this.delimiters.getCombinedDelimiter());
    return Arrays.stream(tokenized).map(PositiveInteger::new).collect(Collectors.toList());
  }

  private Map<String, String> deriveAdditionalDelimiter(String expression) {
    if (expression.length() >= 4 && "//".equals(expression.substring(0, 2)) && "\n".equals(expression.substring(3, 4))) {
      return Map.of("delimiter", String.valueOf(expression.substring(0, 4).charAt(2)), "expression", expression.substring(4));
    }
    return Map.of("delimiter", "", "expression", expression);
  }

  private String trimAdditionalDelimiter(String origin, String additionalDelimiter) {
    if (additionalDelimiter != null) {
      return origin.substring(4);
    }
    return origin;
  }


}
