package racing.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racing.domain.RacingRound;
import racing.vo.RacingCarGamePlayInfo;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest {

  @ParameterizedTest
  @MethodSource("getRacingCarGamePlayInfoArguments")
  @DisplayName("자동차 게임 실행 테스트")
  void play(int totalPlayer, int totalRound) {
    // given
    RacingCarGamePlayInfo info = RacingCarGamePlayInfo.newPlayInfo(totalPlayer, totalRound);

    // when
    List<RacingRound> result = RacingCarGame.newGame(info, () -> true)
            .endGame();

    // then
    assertThat(result).hasSize(totalRound);
  }

  private static Stream<Arguments> getRacingCarGamePlayInfoArguments() {
    return Stream.of(
            Arguments.of(2, 3),
            Arguments.of(3, 2)
    );
  }
}