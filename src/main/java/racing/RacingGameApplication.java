package racing;


import racing.domain.Car;
import racing.domain.RacingGame;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGameApplication {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        int carNo = inputView.getNumberOfCars();
        int chanceNo = inputView.getNumberOfChances();
        inputView.closeScanner();

        RacingGame racingGame = new RacingGame(createCars(carNo), chanceNo);
        racingGame.validateInput(carNo, chanceNo);
        List<Car> cars = racingGame.play();

        ResultView.printRaceResult(cars);
    }

    private static List<Car> createCars(int carNo) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNo; i++) {
            cars.add(new Car(i));
        }
        return cars;
    }
}
