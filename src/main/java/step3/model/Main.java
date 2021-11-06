package step3.model;

import step3.model.view.InputView;
import step3.model.view.OutputView;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ArrayList<String> inputCarList = inputView.InputView();
        MoveOrStrop moveOrStrop = new MoveOrStrop(inputCarList);
        moveOrStrop.moveOrStop();
        OutputView outputView = new OutputView(inputCarList, inputView.getCountOfTry());
        outputView.outputView();
    }
}
