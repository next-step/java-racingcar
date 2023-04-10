package calculator.validator;

import util.StringUtils;

public class PositiveDigitOnlyValidator implements SplitArgumentValidator {

  @Override
  public void validate(String[] splittedArgs) {
    for (String splittedArg : splittedArgs) {
      boolean isPositiveDigit = StringUtils.isPositiveDigit(splittedArg);
      if (!isPositiveDigit) {
        throw new RuntimeException();
      }
    }
  }
}
