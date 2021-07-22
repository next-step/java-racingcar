package step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
  private Car car;

  @BeforeEach
  void init() {
    car = new Car();
  }

  @DisplayName("주어진 숫자의 값이 4이상일 경우 자동차가 한 칸 움직인다.")
  @Test
  void move() {
    final int given = 4;
    car.move(given);

    int actual = car.getLocation();
    assertThat(actual).isEqualTo(1);
  }

  @DisplayName("주어진 숫자의 4미만일 경우 자동차는 움직이지 않는다.")
  @Test
  void stop() {
    final int given = 3;
    car.move(given);

    int actual = car.getLocation();
    assertThat(actual).isEqualTo(0);
  }

  @DisplayName("주어진 random 값의 범위가 0~9 가 아닐경우 예외가 발생한다.")
  @Test
  void notValidNumber() {
    final int given = 10;

    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> car.move(given));
  }

}