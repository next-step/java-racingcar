package racing.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarFactoryTest {

  @ParameterizedTest
  @ValueSource(strings = {"pobi,crong,honux"})
  void 이름을_입력_받아_CAR_객체를_생성한다 (String carsName) {
    List<Car> cars = CarFactory.createCars(carsName);

    assertThat(cars).hasSize(3);
    assertThat(cars.get(0).name()).isEqualTo("pobi");
    assertThat(cars.get(1).name()).isEqualTo("crong");
    assertThat(cars.get(2).name()).isEqualTo("honux");
  }

}