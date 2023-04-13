package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.step3.domain.Car;
import study.step3.factory.CarFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarFactoryTest {

  @DisplayName("자동차 댓수 만큼 자동차를 생성한다.")
  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 4, 5})
  public void create_carArr_numberOfCars(int input) {
    List<Car> carList = CarFactory.createCars(input);

    assertThat(carList.size()).isEqualTo(input);
  }
}
