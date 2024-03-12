package race;

import java.util.ArrayList;
import java.util.List;
import race.domain.Car;
import race.view.InputView;
import race.view.ResultView;

public class RacingCarApplication {

    private final static int NUMBER_OR_CAR_INDEX = 0;
    private final static int COUNT_OF_TRIAL = 1;

    private final static List<Car> cars = new ArrayList<>();

    public static void main(String[] args) {
        List<Integer> input = InputView.requestInput();
        ResultView.start();
        generateCars(input.get(NUMBER_OR_CAR_INDEX));
        racing(input.get(COUNT_OF_TRIAL));
    }

    private static void generateCars(int numberOfCar) {
        for (int i = 0; i < numberOfCar; i++) {
            cars.add(new Car());
        }
    }

    private static void racing(int countOfTrial) {
        for (int i = 0; i < countOfTrial; i++) {
            moveCars();
            ResultView.showProcess(cars);
        }
    }

    private static void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }
}
