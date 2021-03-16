package racing.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.RacingRound;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest {

  @ParameterizedTest
  @ValueSource(ints = { 2, 3 })
  @DisplayName("자동차 게임 실행 테스트")
  void play(int roundCount) {
    // given
    InputView inputView = InputView.newInstance(2, roundCount);

    // when
    List<RacingRound> result =  RacingCarGame.ready(inputView)
            .play();

    ResultView.print(result);

    // then
    assertThat(result).hasSize(roundCount);
  }
}