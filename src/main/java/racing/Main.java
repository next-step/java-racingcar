package racing;

import racing.domain.Cars;
import racing.dto.GameResult;
import racing.service.RacingGame;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        int countOfCar = inputView.InputCountOfUnit();
        int turns = inputView.InputCountOfTurn();

        RacingGame game = new RacingGame(countOfCar, turns);
        List<GameResult> results = game.playGame();

        ResultView.printCarsLocations(results);
    }
}
