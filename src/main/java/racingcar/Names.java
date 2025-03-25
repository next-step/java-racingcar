package racingcar;

import java.util.Arrays;
import java.util.List;

public class Names {

  private static final int MAX_LENGTH = 5;
  private final List<String> names;

  public Names(String[] names) {
    validateNames(names);
    this.names = List.of(names);
  }

  private void validateNames(String[] names) {
    Arrays.stream(names)
        .forEach(this::validateName);
  }

  private void validateName(String name) {
    if (name.length() > MAX_LENGTH) {
      throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
    }
  }

  public List<String> getNames() {
    return names;
  }

  public int size() {
    return names.size();
  }

  public String getNameByIndex(int index) {
    return names.get(index);
  }
}
