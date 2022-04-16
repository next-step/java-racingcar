package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

  private static final int INITIAL_POSITION = 0;
  private static final int MIN_NUMBER_TO_MOVE = 4;
  private static final int CAR_MOVING_DISTANCE = 1;

  @Test
  void getPosition_성공() {
    // given
    Car car = new Car();

    // when
    car.move(MIN_NUMBER_TO_MOVE);

    // then
    assertThat(car.getPosition()).isEqualTo(CAR_MOVING_DISTANCE);
  }

  @Test
  void move_움직임_성공() {
    // given
    Car car = new Car();

    // when
    car.move(MIN_NUMBER_TO_MOVE);

    // then
    assertThat(car.getPosition()).isEqualTo(CAR_MOVING_DISTANCE);
  }

  @Test
  void move_움직임_실패() {
    // given
    Car car = new Car();

    // when
    car.move(MIN_NUMBER_TO_MOVE - 1);

    // then
    assertThat(car.getPosition()).isEqualTo(INITIAL_POSITION);
  }
}
