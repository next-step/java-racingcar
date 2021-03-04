package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

  @ParameterizedTest
  @DisplayName("자동차는 4이상이면 전진하고, 미만이면 정지한다.")
  @CsvSource({"3,false", "0,false", "4,true", "9,true"})
  void move(int randomNumber, boolean expected) {
    Car car = new Car();

    assertThat(car.move(randomNumber)).isEqualTo(expected);
  }
}
