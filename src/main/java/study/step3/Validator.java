package study.step3;

public class Validator {

  public static void validatorNumber(int value) {
    if (value <= 0) {
      throw new IllegalArgumentException("0보다 큰 값을 입력하세요.");
    }
  }

}
