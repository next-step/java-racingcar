package CarRacing;

import view.InputView;
import view.ResultView;

public class Main {


    public static void main(String[] args) {

        InputView inputView = new InputView();

        ResultView resultView = new ResultView();

        Cars cars = new Cars(inputView.insertCarCount());

        int tryCount = inputView.insertTryCount();

        for (int i = 0; i < tryCount; i++) {
            cars.moveAll();
            resultView.printCarPosition(cars.getCars());
        }
    }
}
