package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import racingcar.domain.movable.FixedForwardStrategy;

class CarTest {

    @Test
    void 전략의_move가_참이라면_자동차는_전진한다() {
        Car jpa = Car.of("jpa", new FixedForwardStrategy(true));

        jpa.moveForward();

        assertThat(jpa.getStep()).isEqualTo(1);
    }

    @Test
    void 전략의_move가_거짓이라면_자동차는_전진한다() {
        Car jpa = Car.of("jpa", new FixedForwardStrategy(false));

        jpa.moveForward();

        assertThat(jpa.getStep()).isEqualTo(0);
    }

}
