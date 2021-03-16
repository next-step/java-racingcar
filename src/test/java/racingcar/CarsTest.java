package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class CarsTest {

  @Test
  @DisplayName("[Cars] 우승자를 구하기 위한 가장 큰 위치를 구하는 테스트")
  void getMaxPositionTest() {
    List<Car> inputCars = Arrays
        .asList(new Car("crong", 2), new Car("pobi", 3), new Car("conan", 5));
    Cars cars = new Cars(inputCars);
    assertThat(cars.getMaxPosition()).isEqualTo(5);
  }
}
