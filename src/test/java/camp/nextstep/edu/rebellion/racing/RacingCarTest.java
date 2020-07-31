package camp.nextstep.edu.rebellion.racing;

import camp.nextstep.edu.rebellion.racing.rule.RacingRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarTest {
    @DisplayName("자동차가 움직이는지 확인")
    @Test
    public void moveTest() {
        // given
        RacingRule alwaysGoRule = () -> true;
        RacingCar car = new RacingCar("GO");

        // when
        car.move(alwaysGoRule);

        // then
        assertThat(car.getPosition()).isPositive();
    }

    @DisplayName("자동차가 안 움직이는지 확인")
    @Test
    public void notMoveTest() {
        // given
        RacingRule alwaysStopRule = () -> false;
        RacingCar car = new RacingCar("STOP");

        // when
        car.move(alwaysStopRule);

        // then
        assertThat(car.getPosition()).isZero();
    }
}
