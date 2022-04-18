package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class RacingCarTest {
    class TrueCondition implements Condition {
        @Override
        public boolean getCondition() {
            return true;
        }
    }

    class FalseCondition implements Condition {
        @Override
        public boolean getCondition() {
            return false;
        }
    }

    @Test
    void 이동_테스트() {
        RacingCar racingCar = new RacingCar("차 이름", new TrueCondition());
        assertThat(racingCar.moveOrStop()).isEqualTo(1);
    }

    @Test
    void 멈춤_테스트() {
        RacingCar racingCar = new RacingCar("차 이름", new FalseCondition());
        assertThat(racingCar.moveOrStop()).isEqualTo(0);
    }
}
