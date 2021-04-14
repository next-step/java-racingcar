package study.step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step3.controller.CarRaceController;
import study.step3.domain.Car;
import study.step3.domain.CarFactory;
import study.step3.domain.Cars;
import study.step3.validator.RandomNumber;

public class CarTest {

  @DisplayName("자동차의 위치 입력")
  @Test
  void carInitPositionTest() {
    // given
    int position = 2;

    // when
    Car car = new Car(position);

    // then
    assertThat(car.curPosition()).isEqualTo(2);
  }

  @DisplayName("자동차의 위치 이동")
  @Test
  void carMove() {
    // given
    int position = 2;

    // when
    Car car = new Car();
    car.move(position);

    // then
    assertThat(car.curPosition()).isEqualTo(2);
  }

  @DisplayName("랜덤값을 구하고 4 이상일 경우 이동")
  @Test
  void carRandomMove() {
    // given
    int randomNumber = RandomNumber.generator();

    // when
    Car car = new Car();
    car.move(randomNumber);

    // then
    assertThat(car.curPosition()).isEqualTo(randomNumber);
  }

  @DisplayName("위치가 4 이상일 경우 이동가능한지")
  @Test
  void carPositionNumberIsMove() {
    // given
    int position = 4;

    // when
    Car car = new Car();

    // then
    assertThat(car.isMovable(position)).isTrue();
  }

  @DisplayName("위치가 4 미만일 경우 이동 실패하는지 테스트")
  @Test
  void carMoveFail() {
    // given
    int position = 3;

    // when
    Car car = new Car();

    // then
    assertThat(car.isMovable(position)).isFalse();
  }

  @DisplayName("자동차가 이동할 때 문자열 이동경로 생성")
  @Test
  void carPathWhenMove() {
    // given
    int conditionNumber = 4;
    int position = 1;

    Car movedCar = new Car(position);

    // when
    Car newCar = new Car();
    newCar.move(conditionNumber);

    // then
    assertThat(newCar.equals(movedCar)).isTrue();
  }

  @DisplayName("자동차가 이동 실패했을 때 문자열 이동경로가 null인지")
  @Test
  void carPathNullWhenMove() {
    // given
    int conditionNumber = 3;
    int position = 1;
    Car movedCar = new Car(position);

    // when
    Car newCar = new Car();
    newCar.move(conditionNumber);

    // then
    assertThat(newCar.equals(movedCar)).isFalse();
  }

  @DisplayName("자동차 대수를 입력한 수 만큼 자동차를 생산하는지 테스트")
  @Test
  void carFactory() {
    // given
    int carNumber = 3;

    // when
    Cars cars = CarFactory.makeCar(carNumber);

    // then
    assertThat(cars.getCars().size()).isEqualTo(carNumber);
  }

  @DisplayName("자동차 대수를 0으로 입력했을 때, 자동차 객체 생성에 실패하는지 테스트")
  @Test
  void carFactoryFail() {
    // given
    int carNumber = 0;

    // when
    Throwable thrown = catchThrowable(() -> {
      CarFactory.makeCar(carNumber);
    });

    // then
    assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("자동차 1대를 4회 만큼 이동했을 때 문자열 경로가 생성되는지 테스트")
  @Test
  void carRacingGameWhenOneCarRacing() {
    // given
    int carNumber = 1;
    int times = 4;

    // when
    CarRaceController carRaceController = new CarRaceController();
    List<Car> cars = carRaceController.start(carNumber, times);

    // then
    assertThat(cars.get(0).curPosition()).isGreaterThan(0);
  }


}
