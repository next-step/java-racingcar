package racingCar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {


  @Test
  @DisplayName("4이상인 경우에는 전진한다.")
  void onlyIfFourOrHigher() {
    Car car = new Car();
    assertThat(car.step(4)).isEqualTo(1);
  }

  @Test
  @DisplayName("3이하인 경우에는 멈춘다.")
  void onlyIfThreeLessThen() {
    Car car = new Car();
    assertThat(car.step(3)).isEqualTo(0);

  }


  @Test
  @DisplayName("입력한 횟수 만큼 자동차의 미터기가 작동합니다.")
  void meterTest() {
    Car car = new Car();
    car.carMeter(4);
    car.carMeter(4);
    car.carMeter(3);
    assertThat(car.getMeterParser()).isLessThanOrEqualTo(3);
  }
}