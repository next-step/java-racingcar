package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.InputValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.CarNameException;
import racingcar.model.Car;

public class CarTest {

  private Car car;

  @BeforeEach
  void setUp() {
    car = new Car("nana");
  }

  @Test
  @DisplayName("[Car] 자동차 이동 테스트")
  void moveTest() {
    assertThat(car.getLocation()).isEqualTo(0);
    car.move();
    assertThat(car.getLocation()).isEqualTo(1);
  }

  @ParameterizedTest(name = "[Car] validateName 테스트 - {index}")
  @ValueSource(strings = {"", "abcde", "abcdef"})
  void validateNameTest(String input) {
    assertThatThrownBy(() -> {
      car.validateName(input);
    }).isInstanceOf(CarNameException.class);
  }
}
