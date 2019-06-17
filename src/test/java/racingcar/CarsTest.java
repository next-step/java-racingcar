package racingcar;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarsTest {

  private Cars cars;
  private int numberOfCar = 5;

  @BeforeEach
  public void setup() {
    cars = new Cars(numberOfCar);
  }

  private int[] carsMove() {
    return cars.move();
  }

  @Test
  public void 자동자수만큼_위치값이_리턴된다() {

    assertThat(carsMove().length).isEqualTo(numberOfCar);
  }

  @Test
  public void 자동자는_한번에_1또는0_이동한다() {
    int[] positions = carsMove();
    for (int position : positions) {
      assertThat(position).isLessThan(2);
    }
  }

}
