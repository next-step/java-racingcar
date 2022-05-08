package racing_refactoring;

import racing_refactoring.domain.*;
import racing_refactoring.view.InputView;
import racing_refactoring.view.ResultView;

import java.util.List;

public class RacingMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        List<RacingCar> racingCarList = inputView.inputRacingCar();
        int movementCount = inputView.inputMovementCount();
        RacingCars racingCars = new RacingCars(racingCarList);
        RacingGame racingGame = new RacingGame(racingCars);

        ResultView.printStartLine();
        MovingStrategy movingStrategy = new RandomMovingStrategy();
        for (int i = 0; i < movementCount; i++) {
            racingGame.racing(movingStrategy);
            ResultView.renderProcess(racingCars);
        }

        RacingCars winners = RacingCars.findWinners(racingCars);
        ResultView.renderResult(winners);
    }
}
