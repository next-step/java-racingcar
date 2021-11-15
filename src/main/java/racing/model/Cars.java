package racing.model;

import racing.utils.RandomGenerator;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> findWinners() {
        int maxDistance = findMaxDistance();
        return cars.stream()
                .filter(car -> car.isEqualMovingDistance(maxDistance))
                .collect(Collectors.toList());
    }

    private int findMaxDistance() {
        return cars.stream()
                .mapToInt(Car::getMovingDistance)
                .max()
                .orElseThrow(() -> new NoSuchElementException("cars 중 maxDistance 를 찾는데 실패하였습니다."));
    }

    public void moveAll(RandomGenerator randomGenerator) {
        for (Car car : cars) {
            int randomValue = randomGenerator.nextInt();
            car.move(randomValue);
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
