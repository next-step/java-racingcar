package CarRacing;

import view.InputView;
import view.ResultView;

public class Main {

    public static void main(String[] args) {

        Cars cars = new Cars(InputView.insertCarName());

        int tryCount = InputView.insertTryCount();

        for (int i = 0; i < tryCount; i++) {
            cars.moveAll(new RandomMove());
            ResultView.printCarPosition(cars.getCars());
        }

        ResultView.printWinner(Winner.printWinner(cars.getCars()));

    }
}
