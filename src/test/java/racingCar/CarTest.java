package racingCar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

  private Car car;
  @BeforeEach
  void init() {
    car = new Car();
  }

  @Test
  @DisplayName("자동차는 전진 또는 멈출 수 있다.")
  void ahead() {
    assertThat(car.getRandomValue()).isNotNegative();
  }

  @Test
  @DisplayName("4이상인 경우에는 전진한다.")
  void OnlyIfFourOrHigher() {
    car.setRandomValue(7);
    assertThat(car.move()).isEqualTo("-");
  }
  @Test
  @DisplayName("3이하인 경우에는 멈춘다.")
  void OnlyIfThreeLessThen() {
    car.setRandomValue(3);
    assertThat(car.move()).isEqualTo(null);
  }
}