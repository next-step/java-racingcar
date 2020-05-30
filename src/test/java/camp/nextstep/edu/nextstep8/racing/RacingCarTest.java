package camp.nextstep.edu.nextstep8.racing;

import camp.nextstep.edu.nextstep8.stub.MoveForwardingRuleStub;
import camp.nextstep.edu.nextstep8.stub.NotMoveForwardingRuleStub;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @DisplayName("자동차가 조건이 만족 되었을 경우 움직이는지 확인")
    @Test
    public void moveForwardTest() {
        // given
        RacingCar racingCar = new RacingCar(new MoveForwardingRuleStub());

        // when
        racingCar.move();

        // then
        assertThat(racingCar.getPosition()).isGreaterThan(0);
    }

    @DisplayName("자동차가 조건이 만족 되지 않았을 경우 안 움직이는지 확인")
    @Test
    public void notMoveForwardTest() {
        // given
        RacingCar racingCar = new RacingCar(new NotMoveForwardingRuleStub());

        // when
        racingCar.move();

        // then
        assertThat(racingCar.getPosition()).isEqualTo(0);
    }

}
