package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCars {
    private List<Car> cars;
    private Random random;

    private static final int RANDOM_BOUND = 10;

    public RacingCars(String inputNames) throws Exception {
        this.cars = new ArrayList<>();
        grantCarName(inputNames);
        random = new Random();
    }

    private void grantCarName(String inputNames) throws Exception {
        String[] carNames = inputNames.split(",");
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public List<Car> roundRun() {
        List<Car> roundResults = new ArrayList<>();
        for (Car car : cars) {
            int condition = random.nextInt(RANDOM_BOUND);
            car.move(condition);
            roundResults.add(car);
        }
        return roundResults;
    }

}
