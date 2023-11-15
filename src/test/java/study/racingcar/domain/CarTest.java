package study.racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.racingcar.domain.car.Car;
import study.racingcar.fake.FailRandomGenratorStub;
import study.racingcar.fake.SuccessRandomGenratorStub;
import study.racingcar.util.MoveStatus;
import study.racingcar.util.RandomGenerator;

public class CarTest {

    private Car carAlwaysReturnAboveFour;
    private Car carAlwaysReturnBelowFour;

    private RandomGenerator successRandomGenratorStub = new SuccessRandomGenratorStub(new Random());
    private RandomGenerator failRandomGenratorStub = new FailRandomGenratorStub(new Random());

    private

    @BeforeEach
    void init() {
        carAlwaysReturnAboveFour = new Car("name");
        carAlwaysReturnBelowFour = new Car("name");
    }

    @DisplayName("자동차의 이름이 5글자 이하면 아무런 예외도 발생하지 않습니다.")
    @Test
    void doesNotThroeAnyExceptionWhenCarNameLessThan5Characters(){
        assertThatNoException().isThrownBy(() -> new Car("Four"));
    }

    @DisplayName("자동차의 이름이 5글자를 넘어가면 IllegalArgumentException이 발생합니다.")
    @Test
    void throwIllegalArgumentExceptionWhenCarNameMoreThan5Characters() {
        assertThatThrownBy(() -> new Car("More than 5 characters")).isInstanceOf(
            IllegalArgumentException.class);
    }

    @DisplayName("자동차가 전진합니다.")
    @Test
    void carMustMoveForward() {
        assertThatNoException().isThrownBy(
            () -> carAlwaysReturnAboveFour.canMove(successRandomGenratorStub));
        assertThat(carAlwaysReturnAboveFour.canMove(successRandomGenratorStub)).isEqualTo(
            MoveStatus.MOVE);
    }

    @DisplayName("자동차가 정지합니다.")
    @Test
    void carMustMoveBackward() {
        assertThatNoException().isThrownBy(
            () -> carAlwaysReturnBelowFour.canMove(failRandomGenratorStub));
        assertThat(carAlwaysReturnBelowFour.canMove(failRandomGenratorStub)).isEqualTo(
            MoveStatus.STOP);
    }

}
