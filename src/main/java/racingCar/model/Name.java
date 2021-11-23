package racingCar.model;

import java.util.Objects;

public class Name {

  private static final int NAME_LIMIT_LENGTH = 5;

  private final String value;

  public Name(String value) {
    this.value = validName(value);
  }

  public String getValue() {
    return value;
  }

  private String validName(String name) {
    if (name.length() <= NAME_LIMIT_LENGTH) {
      return name;
    }
    throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다.");
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Name other = (Name) o;
    return Objects.equals(value, other.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
