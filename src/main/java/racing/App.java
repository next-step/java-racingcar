package racing;

import racing.game.Car;
import racing.game.RacingGame;
import racing.game.result.RacingResult;
import racing.game.random.PositiveRandomNumber;

import java.util.ArrayList;
import java.util.List;

import static racing.view.InputView.namesOfCar;
import static racing.view.InputView.numberOfAttempts;
import static racing.view.ResultView.printResult;

public class App {

    public static void main(String[] args) {
        printResult(run(initializeGame()));
    }


    private static RacingGame initializeGame() {
        return new RacingGame(carsFrom(namesOfCar()), numberOfAttempts());
    }

    private static RacingResult run(RacingGame racing) {
        return racing.run();
    }

    private static List<Car> carsFrom(String[] namesOfCar) {
        List<Car> cars = new ArrayList<>();
        addCars(namesOfCar, cars);
        return cars;
    }

    private static void addCars(String[] namesOfCar, List<Car> cars) {
        for (String name : namesOfCar) {
            cars.add(new Car(name, new PositiveRandomNumber()));
        }
    }
}
