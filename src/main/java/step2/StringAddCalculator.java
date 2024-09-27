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
    if (checkNonOrNull(reqStr)) {
      return 0;
    }
    delimiter = customDelimiter(reqStr);
    if (checkMinusAndNonNumber(reqStr)) {
      throw new RuntimeException();
    }

    //커스텀 구분자가 없으면 기본 구분자로 분리
    if (delimiter.isEmpty()) {
      StringNumberToArray("[,:]", reqStr);
    } else {
      StringNumberToArray(delimiter, reqStr);
    }

    return addArrayData(numberStringArray);
  }

  /**
   * 구분자 기준으로 숫자들 분리
   */
  private static void StringNumberToArray(String delimiter, String targetString) {
    numberStringArray = targetString.split(delimiter);
  }

  /**
   * 문자열 배열 내부 값들 합 반환
   */
  private static int addArrayData(String[] Array) {
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
  private static String customDelimiter(String reqStr) {
    if (reqStr.contains("//") && reqStr.contains("\n")) {
      removeCustomString();
      return reqStr.substring(2, 3);
    }
    return "";
  }

  //숫자 이외값 또는 음수시 런타임에러
  private static boolean checkMinusAndNonNumber(String reqStr) throws RuntimeException {
    if (!reqStr.matches("[0-9,:]")) {
      return true;
    }
    return false;
  }

  //빈값이나 null 체크
  private static boolean checkNonOrNull(String reqStr) throws RuntimeException {
    return "".equals(reqStr) || reqStr == null;
  }

}
