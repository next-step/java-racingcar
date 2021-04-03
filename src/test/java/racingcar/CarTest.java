package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

  @Test
  @DisplayName("자동차의 시작 위치는 항상 0이다.")
  public void carFirstPositionTest() {
    Car car = new Car();
    int position = car.getPosition();
    assertThat(position).isEqualTo(0);
  }

  @ParameterizedTest
  @DisplayName("자동차는 전진 시도보다 많이 갈수 없다.")
  @ValueSource(ints = {5, 1, 9})
  public void carMoveForward(int distance) {
    Car car = new Car();
    for (int i = 0; i < distance; ++i) {
      car.tryMove();
    }
    int position = car.getPosition();
    assertThat(position).isLessThanOrEqualTo(distance);
  }
}
