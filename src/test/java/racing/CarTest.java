package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.model.Car;
import racing.strategy.Strategy;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

  private Strategy testMovingStrategy(boolean flag) {
    return () -> flag;
  }

  @ParameterizedTest
  @DisplayName("작동 싸인에 따라 움직이는 지 확인")
  @CsvSource({"true,1", "false,0"})
  void moveOkTest(boolean flag, int result) {
    Car car = new Car(0, testMovingStrategy(flag));
    assertThat(car.move()).isEqualTo(result);
  }
}
