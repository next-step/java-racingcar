package step5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.car.CarStrategy;
import step5.car.RacingCar;
import step5.game.RacingCarGame;
import step5.message.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;

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
        racingCarGame.readyRace("test1, test2, test3", 2);
        assertThat(racingCarGame.getRacingCars()).hasSize(3);
        assertThat(racingCarGame.getAttemptNum()).isEqualTo(2);
    }

    @DisplayName("자동차들을 각각 전진 1회를 시도한다.")
    @Test
    void attemptForwardTest() {
        RacingCarGame carGame = spy(new RacingCarGame()); //실체 객체를 mock
        carGame.readyRace("test1, test2, test3", 3);

        given(carGame.decideForward()) //랜덤으로 전진을 결정하는 메소드를 항상 true로 반환하도록 처리
                .willReturn(true);

        carGame.attemptForwardCar();

        for (CarStrategy car : carGame.getRacingCars()) {
            assertThat(car.getDistance()).isEqualTo(1);
        }
    }

    @DisplayName("자동차들을 우승자를 조회한다.")
    @Test
    void getWinnerTest() {
        List<CarStrategy> cars = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            cars.add(createCar("test" + i, i));
        }
        RacingCarGame carGame = new RacingCarGame(cars);

        List<String> winners = carGame.getWinners();

        assertThat(winners)
                .contains("test3");
    }

    @DisplayName("자동차들의 이름과 시도 횟수를 입력받아 레이싱 준비를 할 시 시도 횟수가 1미만이면 예외를 발생시킨다.")
    @Test
    void readyCarAttemptLessThanOneThrowException() {
        assertThatThrownBy(() -> racingCarGame.readyRace("test1, test2, test3", 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.MINIMUN_ATTEMPT_EXCEPTION.message());
    }

    @DisplayName("자동차를 생성할 시 1대 이하로 입력되면 예외를 발생시킨다.")
    @Test
    void carInputLessThanOneThrowException() {
        assertThatThrownBy(() -> racingCarGame.readyRace("test", 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.MINIMUN_CAR_EXCEPTION.message());
    }

    private RacingCar createCar(String carName, int distance) {
        return new RacingCar(carName, distance);
    }

}

