package step3.view;

import step3.model.CarGroup;

public class ResultView {
    static public void showResultOfTurn(CarGroup resultOfTurn) {
        resultOfTurn.show();
        printBorder();
    }

    static private void printBorder() {
        System.out.println("==========================");
    }
}
