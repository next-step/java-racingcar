package racingrefactoring.util;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingrefactoring.domain.Car;

class FactoryCarTest {

  @Test
  void 이름을_입력_받아서_자동차_객체_생성() {
    String carNames = "car1,car2,car3";

    List<Car> cars = FactoryCar.createCars(carNames);

    assertThat(cars).hasSize(3);
    assertThat(cars.get(0).getName()).isEqualTo("car1");
    assertThat(cars.get(1).getName()).isEqualTo("car2");
    assertThat(cars.get(2).getName()).isEqualTo("car3");
  }

}