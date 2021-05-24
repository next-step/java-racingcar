package car;

import java.util.*;

public class Game {
    private static final int MINIMUM_CAR_AMOUNT = 2;
    private Input input = new Input();
    private Cut cut = new Cut();

    void excute() {
        String[] carInputs = input.inputCarNames();

        List<Car> cars = createCars(carInputs);

        if (cars.size() < MINIMUM_CAR_AMOUNT) {
            return;
        }

        String count = input.inputTryCount();

        Drive drive = new Drive(cars);
        RaceResults raceResults = drive.carRacing(Integer.valueOf(count));
        Output output = new Output(cars, raceResults);

        output.printRaceResult();
    }

    List<Car> createCars(String[] carInputs) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carInputs) {
            cars.add(cut.getCar(carName));
        }

        return cars;
    }
}
