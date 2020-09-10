package step3.main;

import step3.operation.Operation;
import step3.view.InputView;

public class Start {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int numOfCars = inputView.numOfCars();
        int numOfAtp = inputView.numberOfAttempts();
        Operation.gameStart(numOfAtp, numOfCars);
    }
}
