package racing.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class RacingGame {
    private static final int MAX_BOUND = 10;

    private final List<Car> cars;
    private int tryNo;

    public RacingGame(String carNames, int tryNo) {
        this.cars = this.initCars(carNames);
        this.tryNo = tryNo;
    }

    private List<Car> initCars(String carNames) {
        String[] names = carNames.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public void race() {
        this.tryNo--;
        moveCars();
    }

    private void moveCars() {
        for (Car car : this.cars) {
            car.move(getRandomNo());
        }
    }

    private int getRandomNo() {
        Random random = new Random();
        return random.nextInt(MAX_BOUND);
    }
}
