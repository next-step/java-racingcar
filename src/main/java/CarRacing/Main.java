package CarRacing;

import view.InputView;
import view.ResultView;

public class Main {

    static final InputView inputView = new InputView();

    static final ResultView resultView = new ResultView();
    static Cars cars = null;

    public static void main(String[] args) {

        cars = new Cars(inputView.insertCarCount());

        int tryCount = inputView.insertTryCount();

        for (int i = 0; i < tryCount; i++) {
            cars.moveAll();
            resultView.startRacing(cars.getCars());
        }
    }
}
