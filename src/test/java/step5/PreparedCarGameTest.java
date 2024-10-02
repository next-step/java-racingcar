package step5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.car.CarStrategy;
import step5.game.GameStrategy;
import step5.game.PreparedCarGame;
import step5.game.RacingCarGame;
import step5.message.ExceptionMessage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
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
        RacingCarGame carGame = spy(new RacingCarGame()); //실체 객체를 mock

        PreparedCarGame preparedCarGame = new PreparedCarGame();
        preparedCarGame.setGameStrategy(carGame);
        preparedCarGame.ready("test1, test2, test3", attemptNum);

        given(carGame.decideForward()) //랜덤으로 전진을 결정하는 메소드를 항상 true로 반환하도록 처리
                .willReturn(true);

        preparedCarGame.startRace();

        List<List<CarStrategy>> raceSituation = preparedCarGame.getRaceSituation();

        for (CarStrategy car : raceSituation.get(raceSituation.size() - 1)) {
            assertThat(car.getDistance()).isEqualTo(attemptNum);
        }
    }


    @DisplayName("우승자 선별시 아직 시작도 하지않은 게임이면 예외를 발생시킨다.")
    @Test
    void checkStartTest() {
        int attemptNum = 3;

        PreparedCarGame preparedCarGame = new PreparedCarGame();
        preparedCarGame.setGameStrategy(new RacingCarGame());
        preparedCarGame.ready("test1, test2, test3", attemptNum);

        assertThatThrownBy(preparedCarGame::winnerRace)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.GAME_NOT_START.message());
    }

    @DisplayName("자동차게임이 이전에 이미 시작되었다면 예외를 발생시킨다.")
    @Test
    void alreadyStartTest() {
        int attemptNum = 3;

        PreparedCarGame preparedCarGame = new PreparedCarGame();
        preparedCarGame.setGameStrategy(new RacingCarGame());
        preparedCarGame.ready("test1, test2, test3", attemptNum);

        preparedCarGame.startRace();

        assertThatThrownBy(preparedCarGame::startRace)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.GAME_ALREADY_START.message());
    }

}
