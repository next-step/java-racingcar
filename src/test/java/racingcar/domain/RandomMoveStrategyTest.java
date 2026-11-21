package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.util.FixedRandomGenerator;

import static org.assertj.core.api.Assertions.assertThat;

class RandomMoveStrategyTest {

    @Test
    void 랜덤_값이_4_이상이면_움직일_수_있다() {
        MoveStrategy strategy = new RandomMoveStrategy(new FixedRandomGenerator(4));

        assertThat(strategy.movable()).isTrue();
    }
}