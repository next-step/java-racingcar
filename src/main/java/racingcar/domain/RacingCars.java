package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCars {
    private List<Car> cars;
    private Random random;

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

    public List<Car> run() {
        List<Car> results = new ArrayList<>();
        for (Car car : cars) {
            int condition = random.nextInt(10);
            car.move(condition);
            results.add(car);
        }
        return results;
    }


}
