package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {



  @DisplayName("단일 전진 테스트 : 자동차가 MoveStrategy의 조건에 맞춰서 이동하는지 확")
  @Test
  void 단일_전진_테스트 () {
    MoveStrategy moveStrategy = new AlwaysMoveStrategy();
    assertThat(
      Car.of("CarTest").move(moveStrategy)
              .move(moveStrategy)
              .getPositionString()
    ).isEqualTo("CarTest : --");
  }

  @DisplayName("전진 테스트 : 자동차가 주어진 값 만큼 정상적으로 전진 되었는지 확인")
  @ParameterizedTest
  @MethodSource("provideCarAndTargetPosition")
  void 전진_테스트 (Car car, int going, String expected) {
    assertThat(car.move(going).getPositionString()).isEqualTo(expected);
  }

  private static Stream<Arguments> provideCarAndTargetPosition () {
    return Stream.of(
      Arguments.of(Car.of("CarWillGo3Position"), 3, "CarWillGo3Position : ---"),
      Arguments.of(Car.of("CarWillGo5Position"), 5, "CarWillGo5Position : -----"),
      Arguments.of(Car.of("CarWillGo7Position"), 7, "CarWillGo7Position : -------"),
      Arguments.of(Car.of("CarWillGo9Position"), 9, "CarWillGo9Position : ---------")
    );
  }
}
