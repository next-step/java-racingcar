package util;

import java.util.Collection;

public final class CollectionUtils {

  private CollectionUtils() {}

  public static <T> boolean isEmpty(Collection<T> collection) {
    if (collection == null) {
      return true;
    }

    if (collection.isEmpty()) {
      return true;
    }

    return false;
  }
}
