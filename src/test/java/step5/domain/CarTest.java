package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

  private static MoveStrategy moveStrategy = AlwaysMoveStrategy.getInstance();

  @DisplayName("Car 전진 테스트 : 자동차가 주어진 값 만큼 정상적으로 전진 되었는지 확인")
  @ParameterizedTest
  @MethodSource("provideCarAndTargetPosition")
  void 자동차_전진_테스트 (Car car, int expected) {
    assertThat(car.getPosition()).isEqualTo(expected);
  }

  private static Stream<Arguments> provideCarAndTargetPosition () {
    return Stream.of(
      Arguments.of(
        Car.of().move(moveStrategy),
        1
      ),
      Arguments.of(
        Car.of().move(moveStrategy).move(moveStrategy),
        2
      ),
      Arguments.of(
        Car.of().move(moveStrategy).move(moveStrategy).move(moveStrategy),
        3
      )
    );
  }
}
