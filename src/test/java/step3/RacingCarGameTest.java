package step3;

import step3.car.CarStrategy;
import step3.game.RacingCarGame;
import step3.message.ExceptionMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.spy;

public class RacingCarGameTest {

    private RacingCarGame racingCarGame;

    @BeforeEach
    void setCar() {
        racingCarGame = new RacingCarGame();
    }

    @DisplayName("자동차 수와 시도 횟수를 입력받아 레이싱 준비를 한다.")
    @Test
    void readyCarTest() {
        racingCarGame.readyRace(3,2);
        assertThat(racingCarGame.getRacingCars()).hasSize(3);
        assertThat(racingCarGame.getAttemptNum()).isEqualTo(2);
    }

    @DisplayName("자동차들을 각각 전진 1회를 시도한다.")
    @Test
    void attemptForwardTest() {
        RacingCarGame carGame = spy(new RacingCarGame()); //실체 객체를 mock
        carGame.readyRace(3,3);

        given(carGame.decideForward()) //랜덤으로 전진을 결정하는 메소드를 항상 true로 반환하도록 처리
                .willReturn(true);

        carGame.attemptForwardCar();

        for (CarStrategy car : carGame.getRacingCars()) {
            assertThat(car.getDistance()).isEqualTo(1);
        }
    }

    @DisplayName("자동차 수와 시도 횟수를 입력받아 레이싱 준비를 할 시 시도 횟수가 1미만이면 예외를 발생시킨다.")
    @Test
    void readyCarAttemptLessThanOneThrowException() {
        assertThatThrownBy(() -> racingCarGame.readyRace(3,0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.MINIMUN_ATTEMPT_EXCEPTION.message());
    }

    @DisplayName("자동차를 생성할 시 1이하로 입력되면 예외를 발생시킨다.")
    @Test
    void carInputLessThanOneThrowException() {
        assertThatThrownBy(() -> racingCarGame.readyRace(1,2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.MINIMUN_CAR_EXCEPTION.message());
    }

}

