package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Cars {
    private static final int MINIMUM_NUMBER = 1;
    public static final String DELIMITER = ",";

    private List<Car> cars;

    Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(String[] carNames, MovableStrategy movableStrategy) {
        if (carNames.length < MINIMUM_NUMBER) {
            throw new IllegalArgumentException("최소 1대 이상 필요합니다.");
        }
        return new Cars(mapCars(carNames, movableStrategy));
    }

    private static List<Car> mapCars(String[] carNames, MovableStrategy movableStrategy) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(Car.of(carName, movableStrategy));
        }
        return cars;
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }
    public Winners findWinners() {
        Distance farthestDistance = findFarthestDistance();
        List<String> farthestCars = new ArrayList<>();
        cars.forEach(car -> addWinner(car, farthestDistance, farthestCars));
        return Winners.of(farthestCars);
    }

    private Distance findFarthestDistance() {
        cars.sort(Comparator.reverseOrder());
        return cars.get(0).getDistance();
    }

    private void addWinner(Car car, Distance farthestDistance, List<String> farthestCars) {
        if(car.isSameDistance(farthestDistance)) {
            farthestCars.add(car.carName());
        }
    }

    public int size() {
        return cars.size();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }


}
