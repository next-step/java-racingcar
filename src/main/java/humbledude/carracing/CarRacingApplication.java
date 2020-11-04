package humbledude.carracing;

import humbledude.carracing.domain.Car;
import humbledude.carracing.domain.CarRacing;
import humbledude.carracing.domain.RandomFuelGenerator;
import humbledude.carracing.view.InputView;
import humbledude.carracing.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class CarRacingApplication {

    private static InputView inputView = new InputView();
    private static ResultView resultView = new ResultView();

    public static void main(String[] args) {
        List<String> namesOfCars = inputView.getNamesOfCars();
        int numberOfTurns = inputView.getNumberOfTurns();

        List<Car> cars = initializeCars(namesOfCars);
        CarRacing carRacing = new CarRacing(cars, new RandomFuelGenerator());

        resultView.printHeader();
        for (int i = 0; i < numberOfTurns; i++) {
            carRacing.playOneTurn();
            resultView.printCars(cars);
        }

        List<Car> winners = carRacing.getWinners();
        resultView.printWinners(winners);
    }

    private static List<Car> initializeCars(List<String> namesOfCars) {
        List<Car> cars = new ArrayList<>();
        for (String name : namesOfCars) {
            cars.add(new Car(name));
        }
        return cars;
    }

    @Deprecated
    private static List<Car> initializeCars(int numberOfCars) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }
        return cars;
    }
}
