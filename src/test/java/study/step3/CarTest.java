package study.step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.domain.racingGame.Car;

public class CarTest {

  private Car car;

  @BeforeEach
  void setUp() {
    car = new Car();
  }

  @DisplayName("차량 안 움직이는 지 태스트")
  @ParameterizedTest
  @CsvSource(value = {"1,0", "2,0", "3,0"})
  public void notMoveTest(int randomValue, int expected) {
    car.move(randomValue);
    assertThat(car.findTotalDistance()).isEqualTo(expected);
  }

  @DisplayName("차량  움직이는 지 태스트")
  @ParameterizedTest
  @CsvSource(value = {"4,1", "5,1", "6,1", "7,1", "8,1", "9,1"})
  public void moveTest(int randomValue, int expected) {
    car.move(randomValue);
    assertThat(car.findTotalDistance()).isEqualTo(expected);
  }
}
