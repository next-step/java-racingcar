package racingCar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.model.Car;
import racingCar.model.Position;

class CarTest {

  @Test
  @DisplayName("4이상인 경우에는 전진한다.")
  void onlyIfFourOrHigher() {
    Car car = new Car("klom");
    assertThat(car.move(() -> true).toString()).isEqualTo(new Car("klom", new Position(1)).toString());
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
    assertThat(car.toString()).isEqualTo(new Car("klom", new Position(4)).toString());
  }


}