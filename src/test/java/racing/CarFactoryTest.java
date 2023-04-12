package racing;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.Car;
import racing.domain.CarFactory;

class CarFactoryTest {

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 4, 5})
  void 입력_받은_숫자만큼_자동차_객체_생성(int carCount) {
    CarFactory carFactory = new CarFactory();
    List<Car> cars = carFactory.createCars(carCount);

    assertThat(cars.size()).isEqualTo(carCount);
  }

}