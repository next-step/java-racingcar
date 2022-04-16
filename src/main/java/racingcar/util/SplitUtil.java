package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class SplitUtil {

  private static final String DEFAULT_DELIMITER = ",";

  private SplitUtil() {
  }

  public static List<String> splitToList(String input) {
    return Arrays.asList(input.split(DEFAULT_DELIMITER));
  }

  public static List<String> splitToList(String input, String delimiter) {
    return Arrays.asList(input.split(delimiter));
  }
}
