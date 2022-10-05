package step3;

import static step3.InputView.*;

public class Main {
    public static void main(String[] args) {
        int carQuantity = printAndInputCarQuantity();
        int tryCount = printAndInputTryCount();

        ResultView resultView = new ResultView();
        resultView.printResult(carQuantity, tryCount);
    }
}
