package racing.domain.strategy;

public class NameLengthValidationStrategy implements NameValidationStrategy {

  public static int LENGTH_LIMIT = 5;

  @Override
  public boolean isValid(String carName) {
    if (carName.isEmpty()) {
      return false;
    }
    return carName.length() <= LENGTH_LIMIT;
  }
}
