package study.step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step3.domain.GameRound;

public class GameRoundTest {

  @DisplayName("입력 횟수를 0보다 큰 수를 입력했을때, 라운드가 안 끝났는지")
  @Test
  void gameRoundWhenInputTimes() {
    // given
    int times = 3;

    // when
    GameRound gameRound = new GameRound(times);

    // then
    assertThat(gameRound.isEnd()).isFalse();
  }

  @DisplayName("입력 횟수를 0을 입력했을때, 라운드가 끝났는지 확인하는지 테스트")
  @Test
  void gameRoundWhenInputTimesWithZero() {
    // given
    int times = 0;

    // when
    GameRound gameRound = new GameRound(times);

    // then
    assertThat(gameRound.isEnd()).isTrue();
  }

}
