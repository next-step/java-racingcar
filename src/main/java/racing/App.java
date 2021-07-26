package racing;

import racing.domain.Players;
import racing.service.RacingGame;
import racing.view.InputView;
import racing.view.GameResultView;

public class App {

    public static void main(String[] args) {
        Players players = InputView.inputPlayersOfCar();
        int countNumber = InputView.inputNumberOfCount();

        RacingGame racingGame = RacingGame.initialize(players, countNumber);
        GameResultView resultView = racingGame.playGame();

        resultView.printResult();
    }
}