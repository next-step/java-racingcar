package study.step4;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.domain.racingGame.CarNames;
import study.domain.racingGame.Cars;

public class CarsTest {
  Cars cars;

  @DisplayName("가장 주행 거리가 많은 차량 이름 조회 테스트")
  @Test
  public void getMaxDistanceCarNamesTest() {
    this.cars = new Cars(5);
    assertThat(this.cars.getMaxDistanceCarNames()).isInstanceOf(CarNames.class);
  }
}
