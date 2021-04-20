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

  public static void validatorNames(String[] inputNames) {
    if ("".equals(inputNames[0])) {
      throw new IllegalArgumentException(MessageUtil.validatorNamesMessage);
    }

    for (String inputName : inputNames) {
     if (inputName.length() > 5) {
       throw new IllegalArgumentException(MessageUtil.validatorExceededNamesMessage);
     }
    }
  }

}
