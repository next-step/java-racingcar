package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.model.Cars;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

  @DisplayName("자동차 생성 테스트")
  @Test
  void createCars() {
    final Cars cars = new Cars("test1, test2");
    assertThat(cars.getCarsStatus()).hasSize(2);
  }
}
