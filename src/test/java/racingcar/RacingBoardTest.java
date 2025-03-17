package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingBoardTest {

  @Test
  @DisplayName("레이싱보드에는 각 라운드별 자동차들의 위치가 기록된다.")
  void record() {
    int round = 1;
    RacingBoard racingBoard = new RacingBoard(round);
    racingBoard.record(4);
    racingBoard.record(3);
    racingBoard.record(2);

    assertThat(racingBoard.getRecords()).containsExactlyInAnyOrder(4, 3, 2);
    assertThat(racingBoard.getRound()).isEqualTo(round);

  }
}
