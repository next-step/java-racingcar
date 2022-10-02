package racing;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        int numberOfCars = InputView.queryNumberOfCars();
        int numberOfTrials = InputView.queryNumberOfTrials();

        List<Car> cars = createCars(numberOfCars);
        CarRace carRace = new CarRace(cars);
        for (int i = 0; i < numberOfTrials; i++) {
            carRace.race();
            ResultView.printCars(cars);
        }
    }

    private static List<Car> createCars(int numberOfCars) {
        return Stream.generate(Car::new)
                .limit(numberOfCars)
                .collect(Collectors.toList());
    }
}
