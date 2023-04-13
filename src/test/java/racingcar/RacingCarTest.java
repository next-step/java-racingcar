package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.strategy.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void 자동차_이름은_5자를_초과할_수_없다() {
        TestAlwaysMoveStrategy testAlwaysMoveStrategy = new TestAlwaysMoveStrategy();
        assertThatThrownBy(() -> new RacingCar("pobipobi", testAlwaysMoveStrategy))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }
}