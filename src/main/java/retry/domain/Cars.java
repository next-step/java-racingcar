package retry.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {
    private static final int PIVOT_NUMBER = 4;
    private static final int RANDOM_BOUND_NUMBER = 9;
    private static final String DELIMITER = ",";
    private static final int INITIAL_POSITION_VALUE = 0;
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(String carName) {
        this.cars = createCars(carName);
    }

    private List<Car> createCars(String carName) {
        List<Car> cars = new ArrayList<>();
        String[] carNames = carName.split(DELIMITER);
        for (String name : carNames) {
            cars.add(new Car(name, INITIAL_POSITION_VALUE));
        }
        return cars;
    }

    public Cars moveCarsPositionByInterface() {
        List<Car> carsWithPosition = new ArrayList<>();
        for (Car car : this.cars) {
            carsWithPosition.add(car.move(() -> getRandomNumber() >= PIVOT_NUMBER));
        }
        return new Cars(carsWithPosition);
    }

    private int getRandomNumber() {
        return new Random().nextInt(RANDOM_BOUND_NUMBER);
    }

    public int getWinnerPositionValue() {
        int max = INITIAL_POSITION_VALUE;
        for (Car car : this.cars) {
            max = Math.max(max, car.getPosition());
        }
        return max;
    }

    public boolean contains(Car car) {
        return this.cars.contains(car);
    }

    public List<Car> getCars() {
        return cars;
    }

}
