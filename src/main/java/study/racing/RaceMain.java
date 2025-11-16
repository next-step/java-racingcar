package study.racing;

import study.racing.domain.*;

import static study.racing.view.InputView.*;
import static study.racing.view.ResultView.*;

public class RaceMain {

    public static void main(String[] args) {

        Game game = new Game(new Cars(new CarNames(getCarNames())), getRoundCount());

        printStartGame();
        game.playGame();
        printWinners(game.getCars());
    }
}
