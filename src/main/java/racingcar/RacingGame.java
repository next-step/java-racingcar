package racingcar;

import java.util.List;

public class RacingGame {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int carNumber = inputView.getNumberOfCars();
        int tryNumber = inputView.getNumberOfTry();
        List<Car> cars = Car.createCars(carNumber);

        for(int i = 0; i < tryNumber; i++) {
            resultView.printAll(cars);
            System.out.println();
        }
    }
}
