package step4;

import step4.view.input.Input;
import step4.view.input.InputView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        Input input = inputView.receiveInput();

        String[] carNames = input.getCarNames();
        int tryLimit = input.getTryLimit();

        RacingGame racingGame = new RacingGame(carNames, tryLimit);
        racingGame.race(tryLimit);
    }
}
