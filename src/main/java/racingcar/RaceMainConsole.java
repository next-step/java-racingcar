package racingcar;

import racingcar.controller.RaceController;
import racingcar.view.InputView;

public class RaceMainConsole {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        String carNumber = inputView.inputCarCount();
        int moveNumber = inputView.inputMoveCount();

        RaceController raceController = new RaceController();
        raceController.startRace(carNumber, moveNumber);
    }
}
