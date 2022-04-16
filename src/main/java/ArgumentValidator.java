import java.util.function.Predicate;

public class ArgumentValidator {

  private ArgumentValidator() {
  }

  public static <T> void validate(
      T arg,
      Predicate<T> predication,
      String errorMessage
  ) {
    if (!predication.test(arg)) {
      throw new IllegalArgumentException(errorMessage);
    }
  }
}
