package step5;

import step5.domain.race.RacingGame;
import step5.view.input.Input;
import step5.view.input.InputView;
import step5.view.result.ResultView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        Input input = inputView.receiveInput();

        String[] carNames = input.getCarNames();
        int tryLimit = input.getTryLimit();

        RacingGame racingGame = new RacingGame(carNames, tryLimit, new ResultView());
        for (int i = 1; i <= tryLimit; i++)
            racingGame.race();

    }
}
