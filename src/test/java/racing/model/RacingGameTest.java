package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.view.ResultView;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    @DisplayName("레이싱 경주 시작 메서드 호출 성공 (모두가 함께 움직여 동점 승리)")
    void racingGame__ShouldWinAllDrivers() {
        // given
        String[] names = new String[]{"kim", "nick", "june"};
        int numberOfAttempts = 5;
        ResultView resultView = new ResultView();
        CarMovementStrategy carMovementStrategy = () -> true;

        // when
        RacingGame racingGame = new RacingGame(names, carMovementStrategy);
        List<Car> raceDoneCars = racingGame.getResult(numberOfAttempts);
        String result = resultView.getResultView(raceDoneCars, numberOfAttempts);

        // then
        assertThat(result).contains("kim, nick, june가 최종 우승했습니다.");
    }

    @Test
    @DisplayName("레이싱 경주 시작 메서드 호출 성공 (모두가 함께 움직이지 않아 동점 승리)")
    void racingGame2__ShouldWinAllDrivers() {
        // given
        String[] names = new String[]{"kim", "nick", "june"};
        int numberOfAttempts = 5;
        ResultView resultView = new ResultView();
        CarMovementStrategy carMovementStrategy = () -> false;

        // when
        RacingGame racingGame = new RacingGame(names, carMovementStrategy);
        List<Car> raceDoneCars = racingGame.getResult(numberOfAttempts);
        String result = resultView.getResultView(raceDoneCars, numberOfAttempts);

        // then
        assertThat(result).contains("kim, nick, june가 최종 우승했습니다.");
    }

}
