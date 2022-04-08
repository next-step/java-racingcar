package racingCar;

import static org.assertj.core.api.Assertions.assertThat;

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
  void onlyIfFourOrHigher() {
    if (4 <= car.getRandomValue()) {
      assertThat(car.step()).isEqualTo("-");
    }
  }

  @Test
  @DisplayName("3이하인 경우에는 멈춘다.")
  void onlyIfThreeLessThen() {
    if (car.getRandomValue() <= 3) {
      assertThat(car.step()).isEqualTo(null);
    }
  }

  @Test
  @DisplayName("랜덤 값은 0부터 9사이의 값이다.")
  void randomValueRange() {
    car.step();
    assertThat(car.getRandomValue()).isGreaterThanOrEqualTo(0);
    assertThat(car.getRandomValue()).isLessThanOrEqualTo(9);
  }
}