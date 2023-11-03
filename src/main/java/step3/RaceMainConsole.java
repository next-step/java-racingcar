package step3;

import step3.controller.RaceController;
import step3.domain.CarFactory;
import step3.validite.ValidityCheck;
import step3.view.InputView;
import step3.view.OutputView;

public class RaceMainConsole {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        outputView.outputCarPrint();
        int carNumber = inputView.inputCarCount();
        outputView.outputMovePrint();
        int moveNumber = inputView.inputMoveCount();

        RaceController raceController = new RaceController();
        raceController.startRace(carNumber, moveNumber);
    }
}
