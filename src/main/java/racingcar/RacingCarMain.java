package racingcar;

import racingcar.domain.RacingGame;
import racingcar.domain.car.Cars;
import racingcar.view.ResultView;

import java.util.List;

import static racingcar.view.InputView.*;



public class RacingCarMain {
    public static void main(String[] args) {
        ResultView resultView = new ResultView();
        RacingGame racingGame = new RacingGame(getCarNames(), getRacingCounts());
        List<Cars> carsForRace = racingGame.startRace();
        resultView.printRaceResult(carsForRace);

        Cars endCars = new Cars(racingGame.getCars( ));
        resultView.printWinners(endCars.findWinnerNames());
    }
}

