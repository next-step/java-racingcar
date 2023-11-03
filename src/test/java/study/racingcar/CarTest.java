package study.racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car carAlwaysReturnAboveFour;
    private Car carAlwaysReturnBelowFour;

    @BeforeEach
    void init(){
        carAlwaysReturnAboveFour = new Car(new SuccessRandomGenratorStub(new Random()));
        carAlwaysReturnBelowFour = new Car(new FailRandomGenratorStub(new Random()));
    }

    @DisplayName("자동차가 전진합니다.")
    @Test
    void carMustMoveForward(){
        assertThat(carAlwaysReturnAboveFour.decideMovement()).isTrue();
    }

    @DisplayName("자동차가 정지합니다.")
    @Test
    void carMustMoveBackward(){
        assertThat(carAlwaysReturnBelowFour.decideMovement()).isFalse();
    }

}
