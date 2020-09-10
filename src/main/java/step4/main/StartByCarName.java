package step4.main;

import step4.controller.Operation;
import step4.view.InputView;

public class StartByCarName {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String names = inputView.inputNameView();
        int numOfAtp = inputView.numberOfAttempts();
        Operation.gameStartByName(numOfAtp, names);
    }
}
