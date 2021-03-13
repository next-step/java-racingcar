package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.model.CarFactory;
import racing.model.Cars;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

  CarFactory carFactory;

  @BeforeEach
  void setup() {
    carFactory = new CarFactory();
  }

  @ParameterizedTest
  @CsvSource(value = {"1,2"})
  @DisplayName("정상적인 분기가 처리되는지 확인")
  void runCycleTest(int carCount, int attempt) {

    Cars cars = carFactory.makeCars(carCount);

    int result = 0;
    for (int i = 0; i < attempt; i++) {
      if (cars.runCycle()) {
        result += 1;
      }
    }

    assertThat(result).isEqualTo(attempt);
  }
}
