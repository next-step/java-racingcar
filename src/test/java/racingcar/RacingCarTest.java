package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.strategy.*;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @Test
    void 레이싱카가_움직이면_position이_1증가한다() {
        TestAlwaysMoveStrategy testAlwaysMoveStrategy = new TestAlwaysMoveStrategy();
        RacingCar racingCar = new RacingCar("pobi", testAlwaysMoveStrategy);
        racingCar.goOrStop();
        assertThat(testAlwaysMoveStrategy.getPosition())
            .isEqualTo(1);
    }

    @Test
    void 레이싱카가_멈추면_position이_증가하지않는다() {
        TestAlwaysStopStrategy testAlwaysStopStrategy = new TestAlwaysStopStrategy();
        RacingCar racingCar = new RacingCar("pobi", testAlwaysStopStrategy);
        racingCar.goOrStop();
        assertThat(testAlwaysStopStrategy.getPosition())
            .isZero();
    }
}