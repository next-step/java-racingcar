package step3.console;

import step3.domain.CarFactory;
import step3.validite.ValidityCheck;
import step3.view.InputView;
import step3.view.OutputView;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        ValidityCheck validityCheck = new ValidityCheck();
        CarFactory carFactory = new CarFactory();

        outputView.outputCarPrint();
        inputView.inputCarCount();
        validityCheck.positiveNumberCheck(inputView.inputCarCount());
        outputView.outputMovePrint();
        inputView.inputMoveCount();
        validityCheck.positiveNumberCheck(inputView.inputMoveCount());


    }
}
