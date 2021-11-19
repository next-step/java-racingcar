import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarGameTest {

  private String[] playerNames;

  @BeforeEach
  void setUp() {
    this.playerNames = new String[]{"p1", "play1", "player1"};
  }

  @Test
  @DisplayName("플레이어 이름이 주어지고 항상 움직이는 전략인 경우 게임을 진행했을 때, 실제 자동차가 전진했는지 검증하는 통합 테스트")
  void playWithAlwaysMoveStrategyHavePlayerNames() {
    // given
    int roundAmount = 1;
    int expectedMovedDistance = roundAmount;
    MoveStrategy alwaysMoveStrategy = () -> true;
    RacingCarGame racingCarGame = new RacingCarGame(playerNames, roundAmount);

    // when
    racingCarGame.play(alwaysMoveStrategy);

    // then
    Map<Integer, List<RacingCarResult>> results = racingCarGame.getResults().getResults();
    assertThat(results.size()).isEqualTo(roundAmount);
    results.get(0).forEach(result ->
            assertThat(result.getProgress()).isEqualTo(expectedMovedDistance)
    );
  }

  @Test
  @DisplayName("항상 움직이는 전략으로 게임을 진행하면 모두가 승자인지 검증하기 위한 테스트")
  void findWinnerNames() {
    String expectedWinnerNames = "p1, play1, playe";
    int roundAmount = 1;
    MoveStrategy alwaysMoveStrategy = () -> true;
    RacingCarGame racingCarGame = new RacingCarGame(playerNames, roundAmount);

    // when
    racingCarGame.play(alwaysMoveStrategy);

    // then
    List<String> winnerNames = racingCarGame.getResults().getWinnerNames();
    String joinedWinnerNames = Strings.join(winnerNames, RacingCarGameResultView.DELIMITER);
    assertThat(joinedWinnerNames).isEqualTo(expectedWinnerNames);
  }

}
