package racingcar.model;

import java.util.Objects;

public class Name {

  private static int NAME_MIN_LENGTH = 1;
  private static int NAME_MAX_LENGTH = 5;

  private final String value;

  public Name(String value) {
    validateLength(value);
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  private static void validateLength(String value) {
    if (value.length() < NAME_MIN_LENGTH || value.length() > NAME_MAX_LENGTH) {
      throw new IllegalArgumentException(
          String.format("이름은 %d자 이상, %d자 이하여야 합니다.", NAME_MIN_LENGTH, NAME_MAX_LENGTH)
      );
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Name name = (Name) o;
    return Objects.equals(value, name.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
