package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarManagerTest {

  @DisplayName("자동차 댓수 만큼 자동차를 생성한다.")
  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 4, 5})
  public void create_carArr_numberOfCars(int input) {
    Car[] cars = CarManager.createCars(input);

    assertThat(cars.length).isEqualTo(input);
  }

  @DisplayName("자동차들을 랜덤하게 한 칸 전진시키거나 그대로 둔다.")
  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 4, 5})
  public void move_movingORStop_carArr(int input) {
    Car[] cars = CarManager.createCars(input);

    CarManager.moveCars(cars);

    for (Car car : cars) {
      assertThat(car.toString()).containsAnyOf("", "-");
    }
  }
}
