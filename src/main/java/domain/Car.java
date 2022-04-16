package domain;

import static util.Validator.validateArgument;

public class Car {

  private static final String INITIAL_POSITION_ERROR_MESSAGE = "차의 시작 위치는 %d 이상이어야 합니다.";
  private static final int MIN_INITIAL_POSITION = 0;
  private static final int MOVE_DISTANCE = 1;

  private final int minNumberToMove;
  private int position;

  public Car(int initialPosition, int minimumDistanceToMove) {
    validateMinInitialPosition(initialPosition);

    this.position = initialPosition;
    this.minNumberToMove = minimumDistanceToMove;
  }

  public void move(int number) {
    if (number >= minNumberToMove) {
      position += MOVE_DISTANCE;
    }
  }

  public int getPosition() {
    return position;
  }

  private void validateMinInitialPosition(int initialPosition) {
    validateArgument(
        initialPosition,
        (arg) -> arg >= MIN_INITIAL_POSITION,
        String.format(INITIAL_POSITION_ERROR_MESSAGE, MIN_INITIAL_POSITION)
    );
  }
}
