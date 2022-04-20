package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import model.CarName;
import model.CarPosition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CarInfoTest {

  private static final String CAR_NAME = "name";
  private static final int INITIAL_CAR_POSITION = 1;
  private static Car car;
  private static CarName carName;
  private static CarPosition carPosition;
  private static CarInfo carInfo;

  @BeforeAll
  static void setup() {
    car = new Car(CAR_NAME);
    carName = new CarName(CAR_NAME);
    carPosition = new CarPosition(INITIAL_CAR_POSITION);
    carInfo = new CarInfo(carName, carPosition);
  }


  @Test
  void CarInfo_생성_성공() {
    assertDoesNotThrow(() -> new CarInfo(carName, carPosition));
  }

  @Test
  void CarInfo_생성_실패() {
    assertThrows(NullPointerException.class,
        () -> new CarInfo(null, carPosition));
    assertThrows(NullPointerException.class,
        () -> new CarInfo(carName, null));
  }

  @Test
  void getNameOfCar_성공() {
    assertThat(carInfo.getNameOfCar()).isEqualTo(CAR_NAME);
  }

  @Test
  void getPositionOfCar_성공() {
    assertThat(carInfo.getPositionOfCar()).isEqualTo(INITIAL_CAR_POSITION);
  }

  @Test
  void equals_성공() {
    CarInfo another = new CarInfo(carName, carPosition);
    assertThat(carInfo.equals(another)).isTrue();
  }
}
