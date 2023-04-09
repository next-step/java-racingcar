package study.racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

  private Car car;

  @BeforeEach
  public void setUp() {
    car = new Car();
  }

  @Test
  @DisplayName("Car 객체 생성 테스트")
  public void car() {
    assertThat(car.distance()).isEqualTo(0);
  }

  @ParameterizedTest(name = "Car 객체 전진 테스트")
  @CsvSource(value = {"true:1", "false:0"}, delimiter = ':')
  public void forward(boolean movable, int expected) {
    car.forward(movable);
    assertThat(car.distance()).isEqualTo(expected);
  }
}
