package study.racing;

import study.racing.domain.Cars;
import study.racing.domain.Game;
import study.racing.domain.RaceInput;

import static study.racing.view.InputView.*;
import static study.racing.view.ResultView.*;

public class RaceMain {

    public static void main(String[] args) {
        RaceInput raceInput = raceInput();
        Cars cars = new Cars(raceInput.getNames());

        Game game = new Game(cars, raceInput.getNumberOfAttempt());

        printStartGame();
        game.playGame();
        printWinners(cars);
    }
}
