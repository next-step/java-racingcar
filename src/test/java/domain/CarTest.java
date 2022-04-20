package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

  private static final String COLUMN_MARKER = " : ";
  private static final String POSITION_MARKER = "-";
  private static final String DEFAULT_CAR_NAME = "name";
  private static final int INITIAL_POSITION = 0;
  private static final int MIN_NUMBER_TO_MOVE = 4;
  private static final int CAR_MOVING_DISTANCE = 1;


  @Test
  void move_움직임_성공() {
    // given
    Car car = new Car(DEFAULT_CAR_NAME);
    Car expected = new Car(DEFAULT_CAR_NAME, CAR_MOVING_DISTANCE);
    // when
    car.move(MIN_NUMBER_TO_MOVE);

    // then
    assertThat(car.equals(expected)).isTrue();
  }

  @Test
  void move_움직임_실패() {
    // given
    Car car = new Car(DEFAULT_CAR_NAME);
    Car expected = new Car(DEFAULT_CAR_NAME, INITIAL_POSITION);

    // when
    car.move(MIN_NUMBER_TO_MOVE - 1);

    // then
    assertThat(car.equals(expected)).isTrue();
  }

  @Test
  void markPosition_성공() {
    Car car = new Car(DEFAULT_CAR_NAME, CAR_MOVING_DISTANCE);
    String positionMark = car.markPosition();
    assertThat(positionMark).isEqualTo(DEFAULT_CAR_NAME + COLUMN_MARKER + POSITION_MARKER);
  }
}
