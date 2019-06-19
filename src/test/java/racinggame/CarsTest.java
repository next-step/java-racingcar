package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.model.Cars;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

  private Cars cars;

  @BeforeEach
  void setUp() {
    cars = new Cars("test1, test2");
  }

  @DisplayName("자동차 생성 테스트")
  @Test
  void createCars() {
    assertThat(cars.getCars()).hasSize(2);
  }

  @DisplayName("우승자 테스트")
  @Test
  void getWinner() {
    assertThat(cars.getWinner()).isNotBlank().isNotEmpty();
  }
}
