package racingcar;

import racingcar.view.InputView;

public class RacingCarApplication {
    public static void main(String[] args) {
        int carNumber = InputView.insertCar();
        int moveCount = InputView.insertMoveCount();
        InputView.inputClose();

        RacingGame racing = new RacingGame(carNumber,moveCount);
        racing.startRace();

    }
}
