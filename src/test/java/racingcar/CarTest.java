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
  @DisplayName("자동차는 전진하면 위치가 전진한 숫자만큼 변한다.")
  @ValueSource(ints = {5, 1, 9})
  public void carMoveForward(int distance) {
    Car car = new Car();
    for (int i = 0; i < distance; ++i) {
      car.moveOne();
    }
    int position = car.getPosition();
    assertThat(position).isEqualTo(distance);
  }
}
