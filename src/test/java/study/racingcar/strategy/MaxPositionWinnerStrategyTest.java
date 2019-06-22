package study.racingcar.strategy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by wyparks2@gmail.com on 2019-06-22
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
class MaxPositionWinnerStrategyTest {
    @Test
    void maxPosition() {
        MaxPositionWinnerStrategy maxPositionWinnerStrategy = new MaxPositionWinnerStrategy();
        boolean isWinner = maxPositionWinnerStrategy.isWinner(1, 1);

        assertThat(isWinner).isTrue();
    }
}
