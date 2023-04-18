package racingcar.controller;

import racingcar.domain.Game;
import racingcar.domain.RandomNumberGenerator;
import racingcar.domain.GameResult;
import racingcar.view.Billboard;

import static racingcar.view.InputView.askCar;
import static racingcar.view.InputView.askRound;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(askCar(), askRound(), new RandomNumberGenerator());
        GameResult gameResult = game.play();
        Billboard.printGameResult(gameResult);
    }
}
