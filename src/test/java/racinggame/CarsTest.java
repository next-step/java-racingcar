package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.model.Cars;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

  @DisplayName("자동차 생성 테스트")
  @ParameterizedTest
  @ValueSource(ints = {3, 4, 7})
  void createCars(int carCount) {
    final Cars cars = new Cars(carCount);
    assertThat(cars.getCarsStatus()).hasSize(carCount);
  }
}
