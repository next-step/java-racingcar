package study.step4;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

  @DisplayName("차량이름을 통해 차량 생성 테스트")
  @Test
  public void createCarsByNamesTest() {
    String[] inputNames = {"a", "b", "c"};
    CarNames names = new CarNames(inputNames);
    Cars cars = new Cars(names);
    assertThat(cars.getTotalCarsCount()).isEqualTo(inputNames.length);
  }

  @DisplayName("차량 이름이 통해 차량 생성 에러 테스트")
  @Test
  public void createCarsByNullNamesErrorTest() {
    assertThatThrownBy(() -> new Cars(null)).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("차량 이름이 비어있습니다.");
  }

  @DisplayName("차량 이름이 통해 차량 생성 에러 테스트(empty)")
  @Test
  public void createCarsByEmptyNamesErrorTest() {
    assertThatThrownBy(() -> new Cars(new CarNames())).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("차량 이름이 비어있습니다.");
  }
}
