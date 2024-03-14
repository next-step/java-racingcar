package racingCar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarsTest {

  RacingCars racingCars;

  @BeforeEach
  void setUp() {
    List<String> carNames = List.of("pobi", "crong", "honux");
    List<Car> cars = carNames.stream().map(Car::new).collect(Collectors.toList());
    racingCars = new RacingCars(cars);
  }

  @Test
  @DisplayName("레이싱 자동차의 수를 확인한다.")
  void getCarCount() {
    int carCount = racingCars.getCarCount();
    assertThat(carCount).isEqualTo(3);
  }

}
