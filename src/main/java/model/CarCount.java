package model;

import static util.Validator.buildArgumentErrorMessage;

import util.Validator;

public class CarCount extends AbstractImmutableNumberModel {

  private static final String CAR_COUNT_ERROR_MESSAGE = "차 대수는 %d 이상이어야 합니다.";
  private static final int MIN_CAR_COUNT = 1;

  public CarCount(int value) {
    super(value);
  }

  @Override
  public void validateValue(int value) {
    Validator.validateArgument(
        value,
        (arg) -> arg >= MIN_CAR_COUNT,
        buildArgumentErrorMessage(CAR_COUNT_ERROR_MESSAGE, MIN_CAR_COUNT)
    );
  }
}
