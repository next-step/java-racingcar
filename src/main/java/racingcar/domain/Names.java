package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Names {

  private final List<Name> names;

  public Names(String[] names) {
    this.names = Arrays.stream(names)
        .map(Name::new)
        .collect(Collectors.toList());
  }

  public List<String> getNames() {
    return names.stream()
        .map(Name::toString)
        .collect(Collectors.toList());
  }

  public int size() {
    return names.size();
  }

  public String getNameByIndex(int index) {
    return names.get(index).toString();
  }
}
