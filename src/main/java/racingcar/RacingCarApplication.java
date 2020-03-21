package racingcar;

import racingcar.view.InputView;

public class RacingCarApplication {
    public static void main(String[] args) {
        int carNumber = InputView.carNumber();
        int moveCount = InputView.moveCount();
        InputView.inputClose();

        RacingGame racing = new RacingGame(carNumber,moveCount);
        racing.racing();

    }
}
