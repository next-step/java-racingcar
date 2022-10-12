package racingcar.winner.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MoveResultTest {
    @Test
    void compare() {
        MoveResult beforeMove = new MoveResult(0);
        MoveResult afterMove = new MoveResult(0);

        assertThat(beforeMove).isEqualTo(afterMove);
    }

    @Test
    void 움직인결과를_확인한다() {
        MoveResult beforeMove = new MoveResult();
        MoveResult afterMove = beforeMove.move(true);

        assertThat(beforeMove).isNotEqualTo(afterMove);
    }

    @Test
    void 비교가능하다() {
        MoveResult mover = new MoveResult(6);
        MoveResult follower = new MoveResult(4);

        assertThat(mover.compareTo(follower)).isGreaterThan(0);
    }
}