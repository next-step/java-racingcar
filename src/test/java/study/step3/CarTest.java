package study.step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

  @DisplayName("자동차의 전진 조건을 만족하지 못하여 전진하지 못한다.")
  @ParameterizedTest
  @ValueSource(ints = {0, 1, 2, 3})
  public void move_Stopping_lessThan4(int input) {
    Car car = new Car(0);

    car.move(input);

    assertThat(car.toString()).doesNotContain("-");
  }

  @DisplayName("자동차의 전진 조건을 만족하여 전진한다.")
  @ParameterizedTest
  @ValueSource(ints = {4, 5, 6, 7, 8, 9, 10})
  public void move_Moving_4OrMore(int input) {
    Car car = new Car(0);

    car.move(input);

    assertThat(car.toString()).contains("-");
  }
}
