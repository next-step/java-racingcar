package study.racinggame.util;

public class NameValidator {

  private static final int NAME_MAXIMUM_LENGTH = 5;
  private static final String LENGTH_ILLEGAL_ARGUMENT_EXCEPTION = "5자 초과된 이름이 입력되었습니다. 입력된 이름: ";
  private static final String EMPTY_ILLEGAL_ARGUMENT_EXCEPTION = "레이싱카 이름을 입력하시지 않았습니다.";

  private NameValidator() {
  }

  public static String validatedCarName(String carName) {
    return validateNameLength(validateCarNameEmpty(carName));
  }

  private static String validateNameLength(String carName) {
    if (!isValidLength(carName)) {
      throw new IllegalArgumentException(LENGTH_ILLEGAL_ARGUMENT_EXCEPTION + carName);
    }

    return carName;
  }

  private static boolean isValidLength(String carName) {
    return carName.length() <= NAME_MAXIMUM_LENGTH;
  }

  private static String validateCarNameEmpty(String carName) {
    if (isEmptyCarName(carName)) {
      throw new IllegalArgumentException(EMPTY_ILLEGAL_ARGUMENT_EXCEPTION);
    }

    return carName;
  }

  private static boolean isEmptyCarName(String carName) {
    return carName == null || carName.isEmpty();
  }
}
