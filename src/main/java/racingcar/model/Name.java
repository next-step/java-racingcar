package racingcar.model;

import racingcar.exception.CarNameException;

public class Name {

  private static final int MAX_CAR_NAME_LENGTH = 5;
  private String name;

  public Name(String name) {
    validateName(name);
    this.name = name;
  }

  private void validateName(String name) {
    isMaxLength(name);
    isEmpty(name);
  }

  private void isMaxLength(String name) {
    if (name.length() > MAX_CAR_NAME_LENGTH) {
      throw new CarNameException("자동차 이름은 " + MAX_CAR_NAME_LENGTH + "자를 초과할 수 없습니다.");
    }
  }

  private void isEmpty(String name) {
    if ("".equals(name)) {
      throw new CarNameException("자동차 이름을 입력하세요.");
    }
  }

  @Override
  public String toString() {
    return this.name;
  }
}
