package CarRacing;

import view.InputView;
import view.ResultView;

public class Main {

    static InputView inputView = new InputView();
    static ResultView resultView = new ResultView();
    static Winner winner = new Winner();


    public static void main(String[] args) {

        Cars cars = new Cars(inputView.insertCarName());

        int tryCount = inputView.insertTryCount();

        for (int i = 0; i < tryCount; i++) {
            cars.moveAll();
            resultView.printCarPosition(cars.getCars());
        }

        resultView.printWinner(winner.printWinner(cars.getCars()));

    }
}
