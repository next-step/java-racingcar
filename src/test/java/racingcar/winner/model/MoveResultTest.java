package racingcar.winner.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MoveResultTest {
    @Test
    void compare() {
        MoveResult beforeMove = new MoveResult(0);
        MoveResult afterMove = new MoveResult(0);

        Assertions.assertThat(beforeMove).isEqualTo(afterMove);
    }

    @Test
    void 움직인결과를_확인한다() {
        MoveResult beforeMove = new MoveResult();
        MoveResult afterMove = beforeMove.move(true);

        Assertions.assertThat(beforeMove).isNotEqualTo(afterMove);
    }

    @Test
    void 비교가능하다() {
        MoveResult mover = new MoveResult(6);
        MoveResult follower = new MoveResult(4);

        Assertions.assertThat(mover.compareTo(follower)).isGreaterThan(0);
    }
}