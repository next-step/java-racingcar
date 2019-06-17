package racingcar;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarsTest {

  private Cars cars;
  private int numberOfCar = 5;

  @BeforeEach
  public void setup() {
    cars = new Cars(5);
  }

  @Test
  public void 자동차는_햔번에_1또는0_이동한다() {
    cars.moveCars();
    assertThat(cars.getCarsPosition()).containsOnly(0, 1);
  }

  @Test
  public void 자동자수만큼_위치값이_리턴된다() {
    assertThat(cars.getCarsPosition()).hasSize(numberOfCar);
  }


}
