package racingcar.model;

public class Name {

  private static int NAME_MIN_LENGTH = 1;
  private static int NAME_MAX_LENGTH = 5;

  private final String value;

  public Name(String value) {
    validateName(value);
    this.value = value;
  }

  private static void validateName(String value) {
    if (value.isEmpty() || value.length() > NAME_MAX_LENGTH) {
      throw new IllegalArgumentException(
          String.format("이름은 %d자 이상, %d자 이하여야 합니다.", NAME_MIN_LENGTH, NAME_MAX_LENGTH)
      );
    }
  }
}
