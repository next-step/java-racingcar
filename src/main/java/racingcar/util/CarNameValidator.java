package racingcar.util;

import racingcar.exception.CarNameException;

public class CarNameValidator {

  private static final int MAX_CAR_NAME_LENGTH = 5;

  public static void validateName(String name) {
    isProper(name);
    isEmpty(name);
  }

  private static void isProper(String name) {
    if (name.length() > MAX_CAR_NAME_LENGTH) {
      throw new CarNameException("자동차 이름은 5자를 초과할 수 없습니다.");
    }
  }

  private static void isEmpty(String name) {
    if ("".equals(name)) {
      throw new CarNameException("자동차 이름을 입력하세요.");
    }
  }

}
