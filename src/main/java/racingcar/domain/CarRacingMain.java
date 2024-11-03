package racingcar.domain;


import static racingcar.view.InputView.*;
import static racingcar.view.ResultView.*;

public class CarRacingMain {
    public static void main(String[] args) {

        String carsNames = inputCarName();
        int gameRounds = inputGameCount();
        Game game = new Game(carsNames, gameRounds);
        GameResults gameResults = game.play();
        printGameResults(gameResults);
    }
}