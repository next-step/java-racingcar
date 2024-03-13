package racing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.Car;
import racing.util.FixedNumberGeneratorImpl;

class RacingTest {
  @DisplayName("4이상이면 전진할 수 있다.")
  @ParameterizedTest
  @CsvSource(value = {"4,1", "9,1", "3,0", "2,0"}, delimiter = ',')
  void 전진_가능(int input, int expect){
    Car car = new Car(new FixedNumberGeneratorImpl(input));
    car.run();
    assertThat(car.getRunCount()).isEqualTo(expect);
  }

}