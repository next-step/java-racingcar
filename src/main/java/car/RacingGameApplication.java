package car;

import view.InputView;

public class RacingGameApplication {
    public static void main(String[] args) {
        int carInput = InputView.carInput();
        int stageInput = InputView.stageInput();

        RacingGame racingGame = new RacingGame(carInput, stageInput);
        racingGame.progress();
    }
}
