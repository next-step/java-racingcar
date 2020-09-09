package step3.main;

import step3.operation.Operation;
import step3.view.InputView;

public class StartByCarName {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String names = inputView.inputNameView();
        int numOfAtp = inputView.numberOfAttempts();
        Operation.gameStartByName(numOfAtp, names);
    }
}
