package racingcar.util;

public class Parser {

  public final static String CAR_NAME_DELIMITER = ",";

  public static String[] parseCarNames(String inputName) {
    if (inputName == null || "".equals(inputName.trim())) {
      throw new IllegalArgumentException("자동차명을 입력하세요");
    }
    return inputName.split(CAR_NAME_DELIMITER);
  }

}
