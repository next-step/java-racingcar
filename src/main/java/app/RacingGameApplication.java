package app;

import controller.RacingGameController;
import model.Car;
import model.RandomMoveStrategy;
import view.InputView;
import view.ResultView;

import java.util.List;

public class RacingGameApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        String carNamesString = inputView.getCarNames();
        String[] carNames = carNamesString.split(",");
        int numOfRounds = inputView.getNumberOfRounds();
        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy();

        RacingGameController game = new RacingGameController(numOfRounds, carNames, randomMoveStrategy);
        game.startRace();
        List<Car> result = game.getResult();
        resultView.printGameResult(result);
    }
}
