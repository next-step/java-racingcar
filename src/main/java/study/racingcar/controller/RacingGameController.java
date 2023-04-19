package study.racingcar.controller;

import study.racingcar.domain.GameWinner;
import study.racingcar.domain.RacingGame;
import study.racingcar.domain.RacingGameInputs;
import study.racingcar.view.InputView;
import study.racingcar.view.ResultView;

import java.util.Random;

public class RacingGameController {

    public static void main(String[] args) {
        racingCar();
    }

    public static void racingCar () {

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        do {
            String carNamesStr = inputView.setCarNames();
            int numberOfGames = inputView.setGames();

            RacingGame game = new RacingGame(new RacingGameInputs(numberOfGames, carNamesStr));

            resultView.startGame();

            while (!game.isOver()) {
                game.moveCar();

                resultView.resultGame(game.getCars());

                game.nextLap();
            }

            resultView.winner(new GameWinner(game.getCars()).findGameWinner());
        } while (inputView.reset());

        resultView.endGame();
    }
}
