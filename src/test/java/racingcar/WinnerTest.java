package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnerTest {

  @Test
  @DisplayName("Winner가 정상적으로 생성된다.")
  void createWinner() {
    // given
    // when
    String[] names = {"a", "b"};
    Winner winner = Winner.of(Lists.list(names));

    // then
    assertAll(
        () -> assertThat(winner.getWinners()).contains(names),
        () -> assertThat(winner.winnerListString()).isEqualTo(String.join(", ", names))
    );
  }
}
