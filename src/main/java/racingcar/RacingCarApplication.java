package racingcar;

import racingcar.view.InputView;

public class RacingCarApplication {
    public static void main(String[] args) {
        String[] carNames = InputView.insertCar();
        int moveCount = InputView.insertMoveCount();
        InputView.inputClose();

        RacingGame racing = new RacingGame(carNames,moveCount);
        racing.startRace();

    }
}
