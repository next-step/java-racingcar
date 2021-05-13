package car;

import java.util.*;

public class Game {
    private static final int MINIMUM_CAR_AMOUNT = 2;
    private Input input = new Input();
    private Cut cut = new Cut();

    public void excute() {
        String[] carInputs = inputCarNames();

        List<Car> cars = createCars(carInputs);

        if (cars.size() < MINIMUM_CAR_AMOUNT) {
            return;
        }

        String count = inputTryCount();

        outputRacingCars(count, cars);
    }

    private String[] inputCarNames() {
        String carInput = input.carNameinput();
        String[] carInputs = carInput.split(",");

        return carInputs;
    }

    private List<Car> createCars(String[] carInputs) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carInputs) {
            cars.add(cut.getCar(carName));
        }

        return cars;
    }

    private String inputTryCount() {
        return input.countInput();
    }

    private void outputRacingCars(String count, List<Car> cars) {
        Drive drive = new Drive(cars);

        drive.carRacing(Integer.valueOf(count));
    }
}
