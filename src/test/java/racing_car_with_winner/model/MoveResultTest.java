package racing_car_with_winner.model;

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
}