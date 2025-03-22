package racing.types;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class CarRacingGameSimulateResultTest {

  @DisplayName("생성자 테스트1")
  @Test
  void constructorTest1() {
    assertDoesNotThrow(() -> CarRacingGameSimulateResult.valueOf(List.of(new CarGroup())));
  }

  @DisplayName("마지막 시뮬레이션 결과 가져오기 테스트")
  @Test
  void testGetLastSimulateResult() {
    CarGroup carGroup1 = new CarGroup(List.of(
        Car.valueOf(CarName.valueOf("a"), new CarLocation(0)),
        Car.valueOf(CarName.valueOf("b"), new CarLocation(0))
    ));
    CarGroup carGroup2 = new CarGroup(List.of(
        Car.valueOf(CarName.valueOf("a"), new CarLocation(1)),
        Car.valueOf(CarName.valueOf("b"), new CarLocation(0))
    ));
    CarRacingGameSimulateResult result = CarRacingGameSimulateResult.valueOf(
        List.of(carGroup1, carGroup2)
    );

    assertThat(result.getLastSimulateResult()).isEqualTo(carGroup2);
  }
}
