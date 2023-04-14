package study.racinggame.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NameValidator {

  private static final int NAME_MAXIMUM_LENGTH = 5;

  private NameValidator() {
  }

  public static String validatedCarName(String carName) {
    return validateNameLength(validateCarNameEmpty(carName));
  }

  private static String validateNameLength(String carName) {
    if (!isValidLength(carName)) {
      throw new IllegalArgumentException("5자 초과된 이름이 입력되었습니다. 입력된 이름: " + carName);
    }

    return carName;
  }

  private static boolean isValidLength(String carName) {
    return carName.length() <= NAME_MAXIMUM_LENGTH;
  }

  private static String validateCarNameEmpty(String carName) {
    if (isEmptyCarName(carName)) {
      throw new IllegalArgumentException("레이싱카 이름을 입력하시지 않았습니다.");
    }

    return carName;
  }

  private static boolean isEmptyCarName(String carName) {
    return carName == null || carName.isEmpty();
  }
}
