package racingcar;

import java.util.ArrayList;
import java.util.Arrays;

public class Names {

  private final ArrayList<String> names;

  public Names(String unsplitted) {
    String[] splitted = unsplitted.split(",");
    names = new ArrayList<>(splitted.length);
    for (String name : splitted) {
      validate(name);
    }
    names.addAll(Arrays.asList(splitted));
  }

  private void validate(String name) {
    if (name.length() > 5) {
      throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
    }
  }

  public ArrayList<String> getNames() {
    return names;
  }

  public int size() {
    return names.size();
  }

  public String getCarName(int index) {
    return names.get(index);
  }
}
