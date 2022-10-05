package racing;


import racing.domain.RacingGame;
import racing.domain.car.Car;

import java.util.ArrayList;
import java.util.List;

import static racing.view.InputView.namesOfCar;
import static racing.view.InputView.numberOfAttempts;
import static racing.view.ResultView.printRoundResult;
import static racing.view.ResultView.printWinner;

public class App {

    public static void main(String[] args) {
        run(initializeGame(), numberOfAttempts());
    }

    private static RacingGame initializeGame() {
        return new RacingGame(carsFrom(namesOfCar()));
    }

    private static void run(RacingGame racing, int numberOfAttempts) {
        while (numberOfAttempts-- > 0) {
            printRoundResult(racing.runRound());
        }
        printWinner(racing.winner());
    }

    private static List<Car> carsFrom(String[] namesOfCar) {
        List<Car> cars = new ArrayList<>();
        addCars(namesOfCar, cars);
        return cars;
    }

    private static void addCars(String[] namesOfCar, List<Car> cars) {
        for (String name : namesOfCar) {
            cars.add(new Car(name));
        }
    }
}
