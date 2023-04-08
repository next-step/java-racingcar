package racingcar;

import racingcar.domain.Game;
import racingcar.domain.InputData;
import racingcar.view.InputView;

public class Main {

    public static void main(String[] args) {

        final InputData inputData = InputView.getUserInput();
        Game game = new Game(inputData);
        game.start(inputData);
    }

}
