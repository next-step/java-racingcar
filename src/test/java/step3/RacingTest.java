package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RacingTest {

  private static MoveStrategy moveStrategy = new AlwaysMoveStrategy();

  @DisplayName("레이싱 횟수 검증 : 1 이하의 값을 입력 시 IllegalArgumentException 발생")
  @ParameterizedTest
  @MethodSource("provideRacingConstructorArguments")
  void 레이싱_횟수_검증_테스트 (int time, Cars cars, MoveStrategy moveStrategy) {
    assertThatIllegalArgumentException()
      .isThrownBy(() -> Racing.of(time, cars, moveStrategy));
  }

  @DisplayName("레이싱 테스트")
  @Test
  void 레이싱_테스트 () {
    Racing racing = Racing.of(3, Cars.of(3), moveStrategy);
    String[] result = new String[3];

    for (int i = 0; !racing.isRaceEnd(); i++) {
      result[i] = racing.race()
                        .map(v -> v.getPositionString())
                        .collect(Collectors.joining(","));
    }
    assertThat(String.join("\n", result))
      .isEqualTo("-,-,-\n--,--,--\n---,---,---");
  }

  private static Stream<Arguments> provideRacingConstructorArguments () {
    return Stream.of(
      Arguments.of(0, Cars.of(2), moveStrategy),
      Arguments.of(-1, Cars.of(2), moveStrategy)
    );
  }

}
