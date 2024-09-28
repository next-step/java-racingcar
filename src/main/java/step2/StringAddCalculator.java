package step2;

import java.util.Arrays;

public class StringAddCalculator {

  private static String[] numberStringArray;
  private static String delimiter;
  private static String reqStr;

  /**
   * 문자열들어오면 숫자 합 반환해주는 메서드
   */
  public static int splictAndSum(String reqData) throws RuntimeException {
    reqStr = reqData;
    //null이나 빈값이면 0 반환
    if (checkEmptyOrNull()) {
      return 0;
    }
    defineDelimiter();
    checkMinusAndNonNumber();
    changeStringNumberToArray();

    return ArrayDataSum(numberStringArray);
  }

  /**
   * 구분자 기준으로 숫자들 분리
   */
  private static void changeStringNumberToArray() {
    numberStringArray = reqStr.split(delimiter);
  }

  /**
   * 문자열 배열 내부 값들 합 반환
   */
  private static int ArrayDataSum(String[] Array) {
    return Arrays.stream(Array).map(Integer::parseInt).mapToInt(i -> i).sum();
  }

  /**
   * 커스텀 문자열 제거
   */
  private static void removeCustomString() {
    reqStr = reqStr.substring(reqStr.indexOf("\n") + "\n".length());
  }

  /**
   * 커스텀 구분자 기능 문자열 앞부분의 //과 \n 사이 위치문자 찾기 1. 정규표현식으로 해당 부분 찾고 가운데 반환 2. //다음자리문자열 반환
   */
  private static void defineDelimiter() {
    if (reqStr.contains("//") && reqStr.contains("\n")) {
      delimiter = reqStr.substring(2, 3);
      removeCustomString();
    } else if (!reqStr.contains("//") && !reqStr.contains("\n")) {
      delimiter = "[,:]";
    }

  }

  //숫자 이외값 또는 음수시 런타임에러
  private static void checkMinusAndNonNumber() throws RuntimeException {
    if (reqStr.matches(".*([^0-9,:" + delimiter + "]).*")) {
      throw new RuntimeException();
    }
  }

  //빈값이나 null 체크
  private static boolean checkEmptyOrNull() throws RuntimeException {
    return "".equals(reqStr) || reqStr == null;
  }

}
