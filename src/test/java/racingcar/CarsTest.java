package racingcar;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarsTest {

  private Cars cars;
  private String[] carNames = {"name1", "name2", "name3"};

  @BeforeEach
  public void setup() {
    cars = new Cars(carNames);
  }

  @Test
  public void 자동차는_햔번에_1또는0_이동한다() {
    assertThat(cars.moveCars())
        .extracting(Car::getPosition)
        .contains(1, 0);
  }

  @Test
  public void 자동차이름셋팅() {
    assertThat(cars.moveCars())
        .extracting(Car::getName)
        .containsExactly("name1", "name2", "name3");
  }

  @Test
  public void 자동자수만큼_위치값이_리턴된다() {
    assertThat(cars.moveCars()).hasSize(carNames.length);
  }


}
