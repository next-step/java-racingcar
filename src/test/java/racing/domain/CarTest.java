package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {

  private Car car;

  @BeforeEach
  void init() {
    car = new Car(0);
  }

  @Test
  void carStartsAtZero() {
    assertThat(car.getPosition()).isEqualTo(0);
  }

  @ParameterizedTest
  @CsvSource({"4,1", "9,1", "0,0", "3,0"})
  void carGoIfMoreThan4(int randomValue, int expected) {
    int prevPos = car.getPosition();
    assertThat(prevPos).isEqualTo(0);
    car.move(randomValue);
    assertThat(car.getPosition()).isEqualTo(expected);
  }
}
