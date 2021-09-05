package step6;

import step6.domain.Cars;
import step6.domain.RacingGame;
import step6.domain.Referee;
import step6.domain.TryNumber;
import step6.view.InputView;
import step6.view.ResultView;

import java.util.ArrayList;

public class RacingCarApp {
    public static void main(String[] args) {
        Cars cars = new Cars(InputView.requireCarName());
        TryNumber tryNumber = new TryNumber(InputView.requireTryNumber());

        ResultView.printResultGuideMessage();
        RacingGame racingGame = new RacingGame(cars, tryNumber);
        cars = racingGame.run();

        Referee referee = new Referee(cars);
        referee.calculateResults();
        ResultView.printWinnerCars(referee.getWinnerCars());
    }
}
