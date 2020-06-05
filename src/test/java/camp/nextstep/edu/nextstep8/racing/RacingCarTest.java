package camp.nextstep.edu.nextstep8.racing;

import camp.nextstep.edu.nextstep8.stub.MoveForwardingRuleStub;
import camp.nextstep.edu.nextstep8.stub.NotMoveForwardingRuleStub;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarTest {

    @DisplayName("자동차가 조건이 만족 되었을 경우 움직이는지 확인")
    @Test
    public void moveForwardTest() {
        // given
        RacingCar racingCar = new RacingCar("POBI");

        // when
        racingCar.move(new MoveForwardingRuleStub());

        // then
        assertThat(racingCar.getPosition()).isGreaterThan(0);
    }

    @DisplayName("자동차가 조건이 만족 되지 않았을 경우 안 움직이는지 확인")
    @Test
    public void notMoveForwardTest() {
        // given
        RacingCar racingCar = new RacingCar("POBI");

        // when
        racingCar.move(new NotMoveForwardingRuleStub());

        // then
        assertThat(racingCar.getPosition()).isEqualTo(0);
    }

    @DisplayName("자동차에 이름이 부여 되었는지 확인")
    @Test
    public void nameTest() {
        // given
        String name = "POBI";
        RacingCar racingCar = new RacingCar(name);

        // when & then
        assertThat(racingCar.getName()).isEqualTo(name);
    }

    @DisplayName(("자동차에 이름이 부여되지 않을 경우 Exception 발생"))
    @Test
    public void nameThrownTest() {
        // given
        String name = "";

        // when & then
        assertThatThrownBy(() -> {
            RacingCar racingCar = new RacingCar(name);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름을 확인해 주세요");
    }

}

