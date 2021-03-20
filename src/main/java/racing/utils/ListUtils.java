package racing.utils;

import racing.base.BaseCloneable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ListUtils {

  private ListUtils() {
  }

  public static <T> List<T> of(T... args) {
    return Arrays.asList(args);
  }

  public static <T extends BaseCloneable> List<T> deepCopy(List<T> origin) {
    List<T> result = new ArrayList<>();
    for (T t : origin) {
      result.add((T) t.clone());
    }
    return result;
  }

}
