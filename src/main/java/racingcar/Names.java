package racingcar;

import java.util.ArrayList;
import java.util.Arrays;

public class Names {

  private final ArrayList<String> names;

  public Names(String unsplitted) {
    String[] splitted = unsplitted.split(",");
    names = new ArrayList<>(splitted.length);
    names.addAll(Arrays.asList(splitted));
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
