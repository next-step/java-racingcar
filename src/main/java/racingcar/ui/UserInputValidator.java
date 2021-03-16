package racingcar.ui;

public class UserInputValidator {
  public static boolean isNumeric(String str) {
    return str.matches("-?\\d+(\\.\\d+)?");
  }
}
