package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.strategy.AlwaysMoveStrategy;
import racingcar.strategy.AlwaysStopStrategy;
import racingcar.strategy.MoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @Test
    void 레이싱카가_움직이면_position이_1증가한다() {
        MoveStrategy moveStrategy = new AlwaysMoveStrategy();
        RacingCar racingCar = new RacingCar(moveStrategy);
        racingCar.goOrStop();
        assertThat(racingCar.getPosition())
            .isEqualTo(1);
    }

    @Test
    void 레이싱카가_멈추면_position이_증가하지않는다() {
        MoveStrategy moveStrategy = new AlwaysStopStrategy();
        RacingCar racingCar = new RacingCar(moveStrategy);
        racingCar.goOrStop();
        assertThat(racingCar.getPosition())
            .isZero();
    }
}