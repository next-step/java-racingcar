package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {
  private final String NAME = "eun";

  private Car car;

  @BeforeEach
  void init() {
    car = new Car(NAME);
  }

  @ParameterizedTest
  @CsvSource({"4,1", "9,1", "0,0", "3,0"})
  @DisplayName("4이상의 값인 경우 움직인다")
  void carGoIfMoreThan4(int randomValue, int expected) {
    car.move(randomValue);
    assertThat(car).isEqualTo(new Car(NAME, expected));
  }

  @Test
  @DisplayName("동일한 이름은 동일한 차")
  void carsWithSameNameAreEqual(){
    assertThat(car).isEqualTo(new Car(NAME));
  }

  @Test
  void checkSamePosition() {
    assertThat(car.hasSamePosition(new Car(NAME, 0)));
  }

  @Test
  void toStringFormat() {
    assertThat(car.toString()).isEqualTo(NAME + " : " + new Position(0));
  }
}
