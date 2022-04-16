package util;

import java.util.function.Predicate;

public class Validator {

  private Validator() {
  }

  public static <T> void validateArgument(
      T arg,
      Predicate<T> predication,
      String errorMessage
  ) {
    if (arg == null || !predication.test(arg)) {
      throw new IllegalArgumentException(errorMessage);
    }
  }

  public static String buildArgumentErrorMessage(
      String mainMessage,
      Object... formatArguments
  ) {
    return String.format(mainMessage, formatArguments);
  }
}
