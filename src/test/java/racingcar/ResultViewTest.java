package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ResultViewTest {

    @Test
    @DisplayName("자동차 상태를 출력하는 기능")
    void print() {
        RacingGame racingGame = new RacingGame(3, 5);
        racingGame.start();
        ResultView resultView = new ResultView(racingGame);
        resultView.print();
    }

    @Test
    @DisplayName("자동차 이름과 상태를 출력")
    void printCarRacing() {
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
    @DisplayName("우승자 출력")
    void printWinners() {
        List<CarName> carNames = Arrays.asList(
                new CarName("pobi"),
                new CarName("crong"),
                new CarName("honux"));
        RacingGame racingGame = new RacingGameWithCarName(carNames, 5);
        racingGame.start();
        racingGame.pickWinner();
        ResultView resultView = new ResultView(racingGame);
        resultView.printWinners();
    }

}
