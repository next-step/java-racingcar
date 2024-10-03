package step5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.car.CarStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.spy;

public class PreparedCarGameTest {

    @BeforeEach
    void setUp() {
    }

    @DisplayName("자동차 수와 시도 횟수를 입력받아 레이싱을 시작하여 전진한 거리를 검증한다.")
    @Test
    void readyCarTest() {
        int attemptNum = 3;
        step4.game.RacingCarGame carGame = spy(new step4.game.RacingCarGame()); //실체 객체를 mock
        carGame.readyRace("test1, test2, test3", attemptNum);

        given(carGame.decideForward()) //랜덤으로 전진을 결정하는 메소드를 항상 true로 반환하도록 처리
                .willReturn(true);

        step4.game.PreparedCarGame preparedCarGame = new step4.game.PreparedCarGame();
        preparedCarGame.ready(carGame);

        preparedCarGame.startRace();

        for (CarStrategy car : carGame.getRacingCars()) {
            assertThat(car.getDistance()).isEqualTo(attemptNum);
        }
    }


}
