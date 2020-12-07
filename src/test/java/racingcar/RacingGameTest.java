package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class RacingGameTest {

    @Test
    @DisplayName("초간단 자동차 경주 게임 테스트")
    void start() {
        RacingGame racingGame = new RacingGame(3, 5);
        racingGame.start();
        ResultView resultView = new ResultView(racingGame);
        resultView.print();
    }

    @Test
    @DisplayName("자동차 경주(우승자) 게임 테스트")
    void startWithCarName() {
        List<CarName> carNames = Arrays.asList(
                new CarName("pobi"),
                new CarName("crong"),
                new CarName("honux"));
        RacingGame racingGame = new RacingGameWithCarName(carNames, 5);
        racingGame.start();
        ResultView resultView = new ResultView(racingGame);
        resultView.print();
    }

    @Test
    @DisplayName("자동차의 이름과 위치를 가지고 우승자를 판별하는 기능 테스트")
    void pickWinner() {
        List<CarName> carNames = Arrays.asList(
                new CarName("pobi"),
                new CarName("crong"),
                new CarName("honux"));
        RacingGame racingGame = new RacingGameWithCarName(carNames, 5);
        racingGame.start();
        racingGame.pickWinner();
        ResultView resultView = new ResultView(racingGame);
        resultView.print();
    }
}
