package step3;

import static step3.InputView.*;

public class Main {
    public static void main(String[] args) {
        int carQuantity = printAndInputCarQuantity();
        int tryCount = printAndInputTryCount();

        CarStorage carStorage = new CarStorage(new CarAddFactory().addCarsToList(carQuantity));

        ResultView resultView = new ResultView();
        resultView.printResult(carStorage,tryCount);
    }
}
