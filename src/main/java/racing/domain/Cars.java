package racing.domain;

import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.List;

import static racing.domain.CarRacingProperty.*;

public class Cars {

    private final List<Car> cars;
    private int maxDistance;

    public Cars(String carNames) {
        cars = new ArrayList<>();
        createCars(carNames);
    }

    public int getCarCount() {
        return cars.size();
    }

    public String[] getCarNames() {
        return cars.stream()
                .map(Car::getName)
                .toArray(String[]::new);
    }

    public void moveCars(CarConsumer carConsumer) {
        cars.forEach(car -> {
            int distance = car.move(getRandomNumber());
            maxDistance = Math.max(distance, maxDistance);
            acceptCarConsumer(car, carConsumer);
        });
    }

    public String[] getMaxMovedCarNames() {
        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .toArray(String[]::new);
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getRandomNumber() {
        return RandomUtils.nextInt(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }

    private void acceptCarConsumer(Car car, CarConsumer carConsumer) {
        if (carConsumer != null) {
            carConsumer.accept(car.getName(), car.getDistance());
        }
    }

    private void createCars(String carNames) {
        String[] names = carNames.split(CAR_NAME_SEPARATOR);
        for (String name : names) {
            cars.add(new Car(name));
        }
    }
}
