package racing.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import racing.domain.RacingRound;
import racing.view.ResultView;
import racing.vo.RacingCarGamePlayInfo;

import java.util.List;

import static base.BaseMethodSource.PLAY_INFO_ARGUMENTS;
import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest {

  @ParameterizedTest
  @MethodSource(PLAY_INFO_ARGUMENTS)
  @DisplayName("자동차 게임 실행 테스트")
  void play(String playerNames, int totalRound) {
    // given
    RacingCarGamePlayInfo info = RacingCarGamePlayInfo.newPlayInfo(playerNames, totalRound);

    // when
    List<RacingRound> result = RacingCarGame.newGame(() -> true)
            .play(info);

    ResultView.print(result);

    // then
    assertThat(result).hasSize(totalRound);
  }

}