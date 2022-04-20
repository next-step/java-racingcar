package model;

import static util.Validator.buildArgumentErrorMessage;

import util.Validator;

public class TryCount extends AbstractMutableNumberModel {

  private static final String TRY_COUNT_ERROR_MESSAGE = "시도 횟수는 %d 이상이어야 합니다.";
  private static final int MIN_TRY_COUNT = 1;
  private static final int FINISHED_TRY_COUNT = 0;

  public TryCount(int value) {
    super(value);
  }

  public void race() {
    setValue(value - 1);
  }

  public boolean isFinished() {
    return value == FINISHED_TRY_COUNT;
  }

  @Override
  public void validateValue(int value) {
    Validator.validateArgument(
        value,
        (arg) -> arg >= MIN_TRY_COUNT,
        buildArgumentErrorMessage(TRY_COUNT_ERROR_MESSAGE, MIN_TRY_COUNT)
    );
  }
}
