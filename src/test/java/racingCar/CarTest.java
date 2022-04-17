package racingCar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.model.Car;
import racingCar.strategy.CarMoveRandomStrategy;

class CarTest {

  @Test
  @DisplayName("4이상인 경우에는 전진한다.")
  void onlyIfFourOrHigher() {
    Car car = new Car("klom");
    assertThat(car.move(() -> true)).isEqualTo(new Car("klom", 1));
  }

  @Test
  @DisplayName("3이하인 경우에는 멈춘다.")
  void onlyIfThreeLessThen() {
    Car car = new Car("klom");
    assertThat(car.move(() -> false)).isEqualTo(car);
  }

  @Test
  @DisplayName("n회 전진 테스트")
  void advanceTest() {
    Car car = new Car("klom");
    car = car.move(() -> true);
    car = car.move(() -> true);
    car = car.move(() -> true);
    car = car.move(() -> true);
    assertThat(car).isEqualTo(new Car("klom", 4));
  }

  @Test
  @DisplayName("입력한 횟수 만큼 자동차의 미터기가 작동합니다.")
  void meterTest() {
    Car car = new Car("klom");
    car.move(new CarMoveRandomStrategy());
    car.move(new CarMoveRandomStrategy());
    car.move(new CarMoveRandomStrategy());
    assertThat(car.position().increase()).isLessThanOrEqualTo(3);
  }


}