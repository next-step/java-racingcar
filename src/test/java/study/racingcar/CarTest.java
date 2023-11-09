package study.racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.racingcar.fake.FailRandomGenratorStub;
import study.racingcar.fake.SuccessRandomGenratorStub;

public class CarTest {

    private Car carAlwaysReturnAboveFour;
    private Car carAlwaysReturnBelowFour;

    private RandomGenerator successRandomGenratorStub = new SuccessRandomGenratorStub(new Random());
    private RandomGenerator failRandomGenratorStub = new FailRandomGenratorStub(new Random());

    private

    @BeforeEach
    void init(){
        carAlwaysReturnAboveFour = new Car();
        carAlwaysReturnBelowFour = new Car();
    }

    @DisplayName("자동차가 전진합니다.")
    @Test
    void carMustMoveForward(){
        assertThatNoException().isThrownBy(() -> carAlwaysReturnAboveFour.canMove(successRandomGenratorStub));
        assertThat(carAlwaysReturnAboveFour.canMove(successRandomGenratorStub)).isEqualTo(MoveStatus.MOVE);
    }

    @DisplayName("자동차가 정지합니다.")
    @Test
    void carMustMoveBackward(){
        assertThatNoException().isThrownBy(() -> carAlwaysReturnBelowFour.canMove(failRandomGenratorStub));
        assertThat(carAlwaysReturnBelowFour.canMove(failRandomGenratorStub)).isEqualTo(MoveStatus.STOP);
    }

}
