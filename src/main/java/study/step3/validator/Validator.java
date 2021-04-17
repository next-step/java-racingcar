package study.step3.validator;

import study.step3.utils.MessageUtil;

public class Validator {

  private static final int validator_number = 0;

  private Validator() {}

  public static void validatorNumber(int value) {
    if (value == validator_number) {
      throw new IllegalArgumentException(MessageUtil.validatorNumberMessage);
    }
  }

}
