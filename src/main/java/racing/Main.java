package racing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String[] carNames = InputView.queryCarNames();
        List<Car> cars = createCars(carNames);
        int numberOfTrials = InputView.queryNumberOfTrials();
        CarRace race = new CarRace(cars);

        for (int i = 0; i < numberOfTrials; i++) {
            race.round();
            ResultView.printCars(cars);
        }

        ResultView.printWinners(race.getWinners());
    }

    private static List<Car> createCars(String[] carNames) {
        return Arrays.stream(carNames)
                .map(Main::createCar)
                .collect(Collectors.toList());
    }

    private static Car createCar(String carName) {
        Car car = null;
        try {
            car = new Car(carName);
        } catch (CarNameTooLongException e) {
            ResultView.printError(e);
            System.exit(1);
        }
        return car;
    }
}
