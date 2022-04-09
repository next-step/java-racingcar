package racingCar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {


  @Test
  @DisplayName("자동차는 전진 또는 멈출 수 있다.")
  void ahead() {
    Car car = new Car();
    assertThat(car.getRandomValue()).isNotNegative();
  }

  @Test
  @DisplayName("4이상인 경우에는 전진한다.")
  void onlyIfFourOrHigher() {
    Car car = new Car() {
      @Override
      public int getRandomValue() {
        return 7;
      }
    };
    assertThat(car.step()).isEqualTo(1);
  }

  @Test
  @DisplayName("3이하인 경우에는 멈춘다.")
  void onlyIfThreeLessThen() {
    Car car = new Car() {
      @Override
      protected int getRandomValue() {
        return 2;
      }
    };
    assertThat(car.step()).isEqualTo(0);

  }

  @Test
  @DisplayName("랜덤 값은 0부터 9사이의 값이다.")
  void randomValueRange() {
    Car car = new Car();
    car.step();
    assertThat(car.getRandomValue()).isGreaterThanOrEqualTo(0);
    assertThat(car.getRandomValue()).isLessThanOrEqualTo(9);
  }

  @Test
  @DisplayName("입력한 횟수 만큼 자동차의 미터기가 작동합니다.")
  void meterTest() {
    Car car = new Car();
    car.carMeter();
    car.carMeter();
    car.carMeter();
    assertThat(car.getMeterParser()).isLessThanOrEqualTo(3);
  }
}