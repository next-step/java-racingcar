package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    Cars(String[] carNames) {
        this.cars = initCars(carNames);
    }

    private List<Car> initCars(String[] carNames) {
        int numberOfCars = carNames.length;
        List<Car> cars = new ArrayList<>(numberOfCars);
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(i, new Car(carNames[i]));
        }
        return cars;
    }

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    Cars move(Movable movable) {
        List<Car> carList = new ArrayList<>(cars.size());
        for (Car car : cars) {
            carList.add(car.move(movable));
        }
        return new Cars(carList);
    }

    List<Car> getCarsWithMaxDistance(final Cars snapshot) {
        List<Car> winningCars = new ArrayList<>();
        int maxDistance = getMaxDistance(snapshot);

        for (Car car : snapshot.getCars()) {
            addCarLocatedAtMaxDistance(winningCars, car, maxDistance);
        }

        return winningCars;
    }

    private void addCarLocatedAtMaxDistance(List<Car> winningCars, Car car, int maxDistance) {
        if (car.getDistance() == maxDistance) {
            winningCars.add(car);
        }
    }

    private int getMaxDistance(final Cars snapshot) {
        int maxDistance = -1;
        for (Car car : snapshot.getCars()) {
            maxDistance = car.getGreaterDistance(maxDistance);
        }

        return maxDistance;
    }
}
