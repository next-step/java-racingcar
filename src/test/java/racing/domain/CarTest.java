package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.exception.RacingException;

public class CarTest {
  private final String NAME = "eun";

  private Car car;

  @BeforeEach
  void init() {
    car = new Car(NAME);
  }

  @Test
  void carStartsAtZero() {
    assertThat(car.getPosition().getPosition()).isEqualTo(0);
  }

  @ParameterizedTest
  @CsvSource({"4,1", "9,1", "0,0", "3,0"})
  void carGoIfMoreThan4(int randomValue, int expected) {
    car.move(randomValue);
    assertThat(car.getPosition().getPosition()).isEqualTo(expected);
  }

  @Test
  void carsWithSameNameAreEqual(){
    assertThat(car).isEqualTo(new Car(NAME));
  }

  @ParameterizedTest
  @CsvSource({"abcdef", "verylongname"})
  void carNameShouldThrowExceptionWhenMoreThan5(String name) {
    assertThatThrownBy(() -> new Car(name))
        .isInstanceOf(RacingException.class)
        .hasMessageContaining("5자");
  }

}
