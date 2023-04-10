package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableListUtils {

  public static <T> List<T> appendOneWith(List<T> list, T t) {
    if (list == null) {
      throw new NullPointerException("null인 list에는 append 할 수 없습니다.");
    }

    if (list.isEmpty()) {
      return List.of(t);
    }

    if (t == null) {
      throw new NullPointerException("null을 append 할 수 없습니다.");
    }

    List<T> newImmutableList = new ArrayList<>(list.size() + 1);
    newImmutableList.addAll(list);
    newImmutableList.add(t);
    return Collections.unmodifiableList(newImmutableList);
  }
}
