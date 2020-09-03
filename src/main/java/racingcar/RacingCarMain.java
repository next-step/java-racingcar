package racingcar;

import racingcar.domain.RacingGame;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.view.ResultView;


import java.util.List;

import static racingcar.view.InputView.getCarNames;
import static racingcar.view.InputView.getRacingCounts;
import static racingcar.view.ResultView.*;

public class RacingCarMain {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(getCarNames(), getRacingCounts());
        printStartResult();
//        for (int i = 0 ; i < racingGame.getRacingCounts(); i++) {
//            printCars(racingGame.recordOneRacing());
//            printEmptyLine();
//        }
        List<List<Car>> playCars = racingGame.recordAllRacing();
        printCarsResult2(playCars);

        printWinners(racingGame.getCars());
    }
}
