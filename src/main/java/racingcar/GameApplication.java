package racingcar;

import racingcar.domain.*;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;
import racingcar.util.RandomNumberGenerator;

import java.util.List;

public class GameApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        UserInputData userInput = inputView.getUserInput();
        RaceGame raceGame = new RaceGame(userInput);

        run(raceGame);
    }

    private static void run(final RaceGame game) {
        MoveStrategy moveStrategy = new ForwardStrategy(new RandomNumberGenerator());
        List<Positions> positions = game.playGame(moveStrategy);
        ResultView.print(positions);
    }
}
