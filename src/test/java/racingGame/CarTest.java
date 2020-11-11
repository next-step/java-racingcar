package racingGame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingGame.racingGameException.IllegalCarNameLengthException;

class CarTest {

  @Test
  @DisplayName("일반적인 상황의 인스턴스 생성 테스트")
  void createCar() {
    Car car = Car.of("NAME");

    assertThat(car.getPosition()).isEqualTo(0);
  }

  @Test
  @DisplayName("올바르지 않은 형식의 이름 지정")
  void InvalidInstance() {
    assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
        () -> {
          Car car = Car.of(null);
          car = Car.of("");
        }
    );
  }

  @Test
  @DisplayName("긴 이름의 Car 이름")
  void veryLongNameCar() {
    assertThatExceptionOfType(IllegalCarNameLengthException.class).isThrownBy(
        () -> {
          Car car = Car.of("DONSIX");
        }
    );
  }

}
