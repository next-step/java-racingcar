package model;

import util.Validator;

public class CarName {

  private static final int MAX_NAME_LENGTH = 5;
  private static final String INVALID_NAME_ERROR_MESSAGE = String.format(
      "이름의 길이는 %d자 이하여야합니다.", MAX_NAME_LENGTH
  );
  private final String name;


  public CarName(String name) {
    validate(name);
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }

  public void validate(String name) {
    Validator.validateArgument(
        name,
        (arg) -> arg != null && !arg.isEmpty() && !arg.isBlank() && arg.length() <= 5,
        INVALID_NAME_ERROR_MESSAGE
    );
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CarName carName = (CarName) o;
    return name.equals(carName.name);
  }
}
