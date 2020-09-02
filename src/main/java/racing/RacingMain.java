package racing;

import racing.controller.RacingGame;
import racing.strategy.MoveStrategy;
import racing.strategy.RacingMoveStategy;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingMain {

    public static void main(String[] args) {
        String[] nameOfRacingCarList = InputView.getRacingCarInputWithName();

        int countOfRacing = InputView.getRacingInput();

        RacingGame racingGame = new RacingGame(countOfRacing);

        MoveStrategy moveStrategy = new RacingMoveStategy();
        racingGame.start(nameOfRacingCarList, moveStrategy);

        ResultView.viewRacingResult(racingGame.getRacingCars(), countOfRacing);
    }
}
