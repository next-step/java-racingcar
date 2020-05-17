package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class MoveStrategyTest {

  private static MoveStrategy moveStrategy = RandomNumberMoveStrategy.of();

  @DisplayName("전진 조건 테스트: Random에 대한 입력값이 4 이상일 때 전진")
  @ParameterizedTest
  @MethodSource("provideNumberForIsMoved")
  void 전진_조건_테스트 (int number, boolean expected) {
    assertThat(moveStrategy.isMoved(number)).isEqualTo(expected);
  }

  private static Stream<Arguments> provideNumberForIsMoved () {
    return Stream.of(
      Arguments.of(0, false),
      Arguments.of(3, false),
      Arguments.of(4, true),
      Arguments.of(5, true),
      Arguments.of(9, true)
    );
  }
}
