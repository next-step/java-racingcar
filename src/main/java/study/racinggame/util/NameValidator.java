package study.racinggame.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NameValidator {

  private static final int NAME_MAXIMUM_LENGTH = 5;

  private NameValidator() {
  }

  public static List<String> validatedCarNames(String carNames) {
    validateCarNamesNullOrEmpty(carNames);

    return Arrays.stream(carNames.split(","))
            .peek(NameValidator::validateCarNameEmpty)
            .peek(NameValidator::validateNameLength)
            .collect(Collectors.toList());
  }

  private static void validateNameLength(String carName) {
    if (!isValidLength(carName)) {
      throw new IllegalArgumentException("5자 초과된 이름이 입력되었습니다. 입력된 이름: " + carName);
    }
  }

  private static boolean isValidLength(String carName) {
    return carName.length() <= NAME_MAXIMUM_LENGTH;
  }

  private static void validateCarNameEmpty(String carName) {
    if (isEmptyCarName(carName)) {
      throw new IllegalArgumentException("레이싱카 이름을 입력하시지 않았습니다.");
    }
  }

  private static boolean isEmptyCarName(String carName) {
    return carName.isEmpty();
  }

  private static void validateCarNamesNullOrEmpty(String carNames) {
    if (isNullOrEmptyCarNames(carNames)) {
      throw new IllegalArgumentException("등록할 레이싱카 이름들을 입력해주세요.");
    }
  }

  private static boolean isNullOrEmptyCarNames(String carNames) {
    return carNames == null || carNames.isEmpty();
  }
}
