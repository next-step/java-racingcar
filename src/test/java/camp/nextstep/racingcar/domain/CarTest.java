package camp.nextstep.racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.racingcar.domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

  @DisplayName("조건 값이 4 미만인 경우 차량 이동 안함")
  @ParameterizedTest
  @ValueSource(ints = {0, 1, 2, 3})
  void should_Not_Move(int input) {
    Car car = new Car();
    car.move(new DefaultMoveCondition(() -> input));
    assertThat(car.getPosition()).isZero();
  }

  @DisplayName("조건 값이 4 이상인 경우 차량 이동")
  @ParameterizedTest
  @ValueSource(ints = {4, 5, 6, 7, 8, 9, 10})
  void should_Move(int input) {
    Car car = new Car();
    car.move(new DefaultMoveCondition(() -> input));
    assertThat(car.getPosition()).isEqualTo(1);
  }

}
