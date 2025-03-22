package racing.types;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarGroupTest {

  @DisplayName("생성자 테스트1")
  @Test
  void constructorTest1() {
    assertDoesNotThrow(() -> new CarGroup());
  }

  @DisplayName("생성자 테스트2")
  @Test
  void constructorTest2() {
    assertDoesNotThrow(() -> new CarGroup(List.of(new Car())));
  }

  @DisplayName("차들을 move 하면 전략에 따라 차를 움직인다.")
  @ParameterizedTest
  @ValueSource(booleans = {true, false})
  void moveCarsByStrategy(boolean strategyResult) {
    CarGroup carGroup = new CarGroup(List.of(
        Car.valueOf(CarName.valueOf("a")),
        Car.valueOf(CarName.valueOf("b"))
    ));

    CarGroup result = carGroup.toTryMoveCarGroup(() -> strategyResult);

    CarGroup expectedCars = strategyResult
        ? new CarGroup(List.of(
        Car.valueOf(CarName.valueOf("a"), new CarLocation(1)),
        Car.valueOf(CarName.valueOf("b"), new CarLocation(1))
    ))
        : new CarGroup(List.of(
        Car.valueOf(CarName.valueOf("a")),
        Car.valueOf(CarName.valueOf("b"))
    ));

    assertThat(result).isEqualTo(expectedCars);
  }
}
