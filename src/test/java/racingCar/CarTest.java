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
    assertThat(car.move()).isNotNegative();
  }
}