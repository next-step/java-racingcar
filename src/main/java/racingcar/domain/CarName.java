package racingcar.domain;

import java.util.Objects;

public class CarName {

  public static final int MAX_NAME_LENGTH = 5;
  public static final String EMPTY_STRING_ERROR_MESSAGE = "비어있는 이름은 유효하지 않은 이름입니다.";
  public static final String MAX_LENGTH_ERROR_MESSAGE = "자동차의 이름은 최대 5자입니다. 입력한 이름: ";

  private final String name;

  public CarName(String name) {
    validateName(name);
    this.name = name;
  }

  public String getName() {
    return name;
  }

  private void validateName(String name) {
    validateEmptyName(name);
    validateNameMaxLength(name);
  }

  private void validateEmptyName(String name) {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException(EMPTY_STRING_ERROR_MESSAGE);
    }
  }

  private void validateNameMaxLength(String name) {
    if (name.length() > MAX_NAME_LENGTH) {
      throw new IllegalArgumentException(MAX_LENGTH_ERROR_MESSAGE + name);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CarName)) {
      return false;
    }
    CarName carName = (CarName) o;
    return Objects.equals(getName(), carName.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName());
  }
}
