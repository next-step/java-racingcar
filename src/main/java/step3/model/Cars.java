package step3.model;

import java.util.ArrayList;
import java.util.List;

import static step3.utils.RacingUtils.generateRandomNumber;

public class Cars {
    private static final int BOUND = 10;
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void checkForwardConditionAndGo() {
        for (Car car : cars) {
            checkRandomNumber(car);
        }
    }

    public void checkRandomNumber(Car car) {
        int randomNumber = generateRandomNumber(BOUND);
        car.availableForward(randomNumber);
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public static Cars generateCars(int carCount) {
        List<Car> tempCars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            Car car = new Car(0);
            tempCars.add(car);
        }

        return new Cars(tempCars);
    }

}
