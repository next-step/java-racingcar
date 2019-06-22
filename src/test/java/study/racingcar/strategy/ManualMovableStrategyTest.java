package study.racingcar.strategy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by wyparks2@gmail.com on 2019-06-18
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
class ManualMovableStrategyTest {
    @Test
    void 움직인다() {
        assertThat(new ManualMovableStrategy(true).canMove()).isTrue();
    }

    @Test
    void 움직이지_않는다() {
        assertThat(new ManualMovableStrategy(false).canMove()).isFalse();
    }
}