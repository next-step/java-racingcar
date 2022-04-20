package model;

import static util.Validator.buildArgumentErrorMessage;
import static util.Validator.validateArgument;

public class CarPosition extends AbstractMutableNumberModel implements Comparable<CarPosition> {

  private static final String POSITION_MARKER = "-";
  private static final String INITIAL_POSITION_ERROR_MESSAGE = "차의 시작 위치는 %d 이상이어야 합니다.";
  private static final int MIN_INITIAL_POSITION = 0;

  public CarPosition(int value) {
    super(value);
  }

  public void add(int number) {
    setValue(value + number);
  }

  @Override
  public String toString() {
    return POSITION_MARKER.repeat(value);
  }

  @Override
  public void validateValue(int value) {
    validateArgument(
        value,
        (arg) -> arg >= MIN_INITIAL_POSITION,
        buildArgumentErrorMessage(INITIAL_POSITION_ERROR_MESSAGE, MIN_INITIAL_POSITION)
    );
  }

  @Override
  public int compareTo(CarPosition other) {
    if (this.value > other.value) {
      return 1;
    } else if (this.value == other.value) {
      return 0;
    }
    return -1;
  }
}
