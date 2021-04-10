package study.step3;

public class Validator {

  private static final int validator_number = 0;

  public static void validatorNumber(int value) {
    if (value == validator_number) {
      throw new IllegalArgumentException(MessageUtil.validatorNumberMessage);
    }
  }

}
