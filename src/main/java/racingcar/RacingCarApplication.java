package racingcar;

import racingcar.car.Cars;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarApplication {

    public static void main(String[] args) {

        Cars cars = new Cars(InputView.inputNameOfCars());
        int racingTime = Integer.parseInt(InputView.inputCountOfGame());

        ResultView.printResultTitle();
        for (int i = 0; i < racingTime; i++) {
            cars.moveCars();
            ResultView.printEachRacing(cars);
        }

        ResultView.printWinnerCars(cars.getWinnerCars());
    }
}
