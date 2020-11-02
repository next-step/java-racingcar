package humbledude.carracing;

import java.util.ArrayList;
import java.util.List;

public class CarRacingApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int numberOfCars = inputView.getNumberOfCars();
        int numberOfTurns = inputView.getNumberOfTurns();

        List<Car> cars = initializeCars(numberOfCars);
        CarRacing carRacing = new CarRacing(cars, new RandomFuelGenerator());

        ResultView resultView = new ResultView();
        resultView.printHeader();
        for (int i = 0; i < numberOfTurns; i++) {
            carRacing.playOneTurn();
            resultView.printCars(cars);
        }
    }

    private static List<Car> initializeCars(int numberOfCars) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }

        return cars;
    }
}
