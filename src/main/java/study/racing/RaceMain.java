package study.racing;

import study.racing.domain.Cars;
import study.racing.domain.Game;
import study.racing.domain.RaceInput;

import static study.racing.view.InputView.*;
import static study.racing.view.ResultView.*;

public class RaceMain {

    public static void main(String[] args) {
        RaceInput raceInput = raceInput();

        Game game = new Game(new Cars(raceInput.getNames()), raceInput.getNumberOfAttempt().value());

        printStartGame();
        game.playGame();
        printWinners(game.getCars());
    }
}
