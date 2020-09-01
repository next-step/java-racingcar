package racingcar;

import racingcar.domain.RacingGame;
import racingcar.domain.car.Cars;
import racingcar.view.ResultView;

import java.util.List;

import static racingcar.view.InputView.*;
import static racingcar.view.ResultView.printRaceResult;
import static racingcar.view.ResultView.printWinners;


public class RacingCarMain {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(getCarNames(), getRacingCounts());
        List<Cars> carsForRace = racingGame.startRace();
        printRaceResult(carsForRace);

        Cars cars = new Cars(racingGame.getCars( ));
        printWinners(cars.findWinnerNames());
        }
    }

