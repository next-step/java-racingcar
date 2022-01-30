package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {
    private static final int MAX_RANGE = 10;
    private static final int FORWARD_NUMBER = 4;

    private List<Car> cars = new ArrayList<>();
    private StringBuilder result = new StringBuilder();

    public Racing() {
    }

    public void race(List<String> carNames, int tryCount) {
        registerCar(carNames);
        while (tryCount > 0) {
            move();
            calculateResult();
            tryCount--;
        }
    }

    private void registerCar(List<String> carNames) {
        for (String carName : carNames) {
            cars.add(Car.of(carName));
        }
    }

    private void move() {
        for (Car car : cars) {
            int randomNumber = makeRandomNumber();
            if (randomNumber >= FORWARD_NUMBER) {
                car.moveForward();
            }
        }
    }

    private int makeRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_RANGE);
    }

    private void calculateResult() {
        for (Car car : cars) {
            result.append(car.getName()).append(" : ");
            for (int i = 0; i < car.getLocation(); i++) {
                result.append('-');
            }
            result.append("\n");
        }
        result.append("\n");
    }

    public List<Car> getCarInfo() {
        return cars;
    }

    public String getResult() {
        return result.toString();
    }
}
