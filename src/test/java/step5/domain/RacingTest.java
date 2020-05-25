package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step5.view.ResultView;

import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingTest {

  private static MoveStrategy moveStrategy = AlwaysMoveStrategy.getInstance();

  @DisplayName("레이싱 횟수 검증 : 1 이하의 값을 입력 시 IllegalArgumentException 발생")
  @ParameterizedTest
  @MethodSource("provideRacingConstructorArguments")
  void 레이싱_횟수_검증_테스트 (Cars cars, int time, MoveStrategy moveStrategy) {
    assertThatIllegalArgumentException()
      .isThrownBy(() -> Racing.of(cars, time, moveStrategy));
  }

  @DisplayName("레이싱 테스트")
  @Test
  void 레이싱_테스트 () {
    Racing racing = Racing.of(Cars.of("a,b,c".split(",")),3, moveStrategy);

    while (racing.isRaceEnd()) {
      racing.race();
    }

    assertEquals(3, racing.getWinners().count());
    assertEquals(3, racing.getWinners().findAny()
                                                .orElseThrow(RuntimeException::new)
                                                .getPosition());
  }

  private static Stream<Arguments> provideRacingConstructorArguments () {
    return Stream.of(
      Arguments.of(Cars.of("a,b".split(",")), 0, moveStrategy),
      Arguments.of(Cars.of("a,b".split(",")), -1, moveStrategy)
    );
  }
}
