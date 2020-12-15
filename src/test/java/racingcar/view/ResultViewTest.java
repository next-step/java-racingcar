package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.*;

import java.util.Arrays;

public class ResultViewTest {

    @Test
    @DisplayName("자동차 상태를 출력하는 기능")
    void print() {
        ResultView resultView = new ResultView();
        RacingGame racingGame = new RacingGame(5);
        resultView.print();
        while (racingGame.hasTryCount()) {
            RacingCars cars = racingGame.start(3, 5);
            resultView.printRacingCars(cars);
        }
    }

    @Test
    @DisplayName("자동차 이름과 상태를 출력")
    void printCarRacing() {
        ResultView resultView = new ResultView();
        CarNames carNames = new CarNames(Arrays.asList(
                new CarName("pobi"),
                new CarName("crong"),
                new CarName("honux")));
        RacingGame racingGame = new RacingGameWithCarName(carNames, 5);
        resultView.print();
        while (racingGame.hasTryCount()) {
            RacingCars cars = racingGame.start(carNames.size(), 5);
            resultView.printRacingCars(cars);
        }
    }

    @Test
    @DisplayName("우승자 출력")
    void printWinners() {
        ResultView resultView = new ResultView();
        CarNames carNames = new CarNames(Arrays.asList(
                new CarName("pobi"),
                new CarName("crong"),
                new CarName("honux")));
        RacingGame racingGame = new RacingGameWithCarName(carNames, 5);
        resultView.print();
        while (racingGame.hasTryCount()) {
            RacingCars cars = racingGame.start(carNames.size(), 5);
            resultView.printRacingCars(cars);
        }
        resultView.printWinners(racingGame.pickWinners());
    }

}
