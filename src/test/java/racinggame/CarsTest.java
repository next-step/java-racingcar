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

  @DisplayName("우승자 테스트 - 우승자가 1명")
  @Test
  void getWinner() {

    cars.getCars().get(0).move(4);
    cars.getCars().get(1).move(1);

    assertThat(this.cars.getWinner(cars.getMax()))
        .isNotBlank()
        .isEqualTo("test1");
  }

  @DisplayName("우승자 테스트 - 우승자가 2명")
  @Test
  void getWinners() {
    cars = new Cars("test1, test2, test3");

    cars.getCars().get(0).move(5);
    cars.getCars().get(1).move(2);
    cars.getCars().get(2).move(7);

    assertThat(this.cars.getWinner(cars.getMax()))
        .isEqualTo("test1, test3");
  }
}
