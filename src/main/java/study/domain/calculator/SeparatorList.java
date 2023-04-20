package study.domain.calculator;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class SeparatorList {

  private final String REGEX_DELIMITER = "|";

  private Set<String> separatorSet;

  public SeparatorList() {
    separatorSet = new HashSet<>();
    add(",");
    add(":");
  }

  public void add(String delimiter) {
    if (delimiter == null || delimiter.trim().isEmpty()) {
      return;
    }
    if (separatorSet == null || separatorSet.contains(delimiter)) {
      return;
    }
    separatorSet.add(delimiter);
  }

  public String makeSeparatorRegex() {
    return separatorSet
        .stream()
        .map(String::valueOf)
        .collect(Collectors.joining(REGEX_DELIMITER));
  }

}
