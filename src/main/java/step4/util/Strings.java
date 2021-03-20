package step4.util;

import java.util.Arrays;

public class Strings {

  private static String VARIABLE_NAME_SPLIT = ",";
  private static String INPUT_ERROR_CAR_NAMES = "입력된 차량들의 이름을 확인하세요. 1~5자 허용입니다.";
  private static String INPUT_ERROR_CAR_FULL_NAMES = "입력된 차량들의 전체 이름이 잘못 되었습니다.";

  private Strings() {
  }

  public static boolean checkNotNullOrNotEmpty(String str) {
    return str != null && !str.trim().isEmpty();
  }

  public static void checkFactorsNotEmpty(String str, String splitter) {
    boolean stringEmptyCheck = checkNotNullOrNotEmpty(str);
    long inValidCount = Arrays.stream(str.split(splitter)).filter(name -> name.trim().isEmpty()).count();
    if(inValidCount>0 || !stringEmptyCheck) {
      throw new IllegalArgumentException(INPUT_ERROR_CAR_NAMES);
    }
  }

  public static void checkFactorsMaximumLength(String str, String splitter, int maxLength) {
    long inValidCount = Arrays.stream(str.split(splitter)).filter(name -> name.length() > maxLength).count();
    if (inValidCount > 0) {
      throw new IllegalArgumentException();
    }
  }

  public static void isValidFactorNames(String carNames, int maxLangth) {
    Strings.checkFactorsMaximumLength(carNames, VARIABLE_NAME_SPLIT, maxLangth);
    Strings.checkFactorsNotEmpty(carNames, VARIABLE_NAME_SPLIT);
  }

  public static void isValidCarNames(String carNames) {
    if (!Strings.checkNotNullOrNotEmpty(carNames)) {
      throw new IllegalArgumentException(INPUT_ERROR_CAR_FULL_NAMES);
    }

  }
}
