package step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step4.model.CarFactory;
import step4.model.Cars;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

  @ParameterizedTest
  @CsvSource(value = {"1,2"})
  @DisplayName("정상적인 분기가 처리되는지 확인")
  void runCycleTest(String carNames, int attempt) {

    Cars cars = CarFactory.makeCars(carNames);

    int result = 0;
    for (int i = 0; i < attempt; i++) {
      if (cars.runCycle()) {
        result += 1;
      }
    }

    assertThat(result).isEqualTo(attempt);
  }
}
