package model;

import static util.Validator.buildArgumentErrorMessage;
import static util.Validator.validateArgument;

public class CarPosition extends AbstractMutableNumberModel {

  private static final String INITIAL_POSITION_ERROR_MESSAGE = "차의 시작 위치는 %d 이상이어야 합니다.";
  private static final int MIN_INITIAL_POSITION = 0;

  public CarPosition(int value) {
    super(value);
  }

  public void add(int number) {
    setValue(value + number);
  }

  @Override
  public void validateValue(int value) {
    validateArgument(
        value,
        (arg) -> arg >= MIN_INITIAL_POSITION,
        buildArgumentErrorMessage(INITIAL_POSITION_ERROR_MESSAGE, MIN_INITIAL_POSITION)
    );
  }

}
