package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

  private static final String DEFAULT_CAR_NAME = "name";
  private static final int INITIAL_POSITION = 0;
  private static final int MIN_NUMBER_TO_MOVE = 4;
  private static final int CAR_MOVING_DISTANCE = 1;


  @Test
  void move_움직임_성공() {
    // given
    Car car = new Car(DEFAULT_CAR_NAME);

    // when
    car.move(MIN_NUMBER_TO_MOVE);

    // then
    assertThat(car.getCarInfo().getPositionOfCar()).isEqualTo(CAR_MOVING_DISTANCE);
  }

  @Test
  void move_움직임_실패() {
    // given
    Car car = new Car(DEFAULT_CAR_NAME);

    // when
    car.move(MIN_NUMBER_TO_MOVE - 1);

    // then
    assertThat(car.getCarInfo().getPositionOfCar()).isEqualTo(INITIAL_POSITION);
  }

  @Test
  void carInfo_획득_성공() {
    Car car = new Car(DEFAULT_CAR_NAME);
    CarInfo carInfo = car.getCarInfo();
    assertThat(carInfo.getNameOfCar().equals(DEFAULT_CAR_NAME)).isTrue();
    assertThat(carInfo.getPositionOfCar()).isEqualTo(INITIAL_POSITION);
  }
}
