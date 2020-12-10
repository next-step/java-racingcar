package step3.domain;

import step3.Car;
import step3.Distance;
import step3.domain.strategy.MovingStrategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Cars {
    private List<Car> cars = new ArrayList<>();

    public Cars(int carCount) {
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public Cars(String... names) {
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public void move(MovingStrategy movingStrategy) {
        cars.forEach(car -> car.accelerate(movingStrategy)); // 모든 자동차 주행
    }

    public Distance pickDistance(String condition) {
        Stream<Distance> distanceStream = cars.stream()
                .map(Car::getDistance);
        if ("max".equals(condition)) {
            return distanceStream.max(Comparator.comparingInt(Distance::getMileage))
                    .get();
        }
        return distanceStream.min(Comparator.comparingInt(Distance::getMileage))
                .get();
    }

    public List<String> getWinnerCarNames(Distance distance) {
        return cars.stream()
                .filter(c -> c.getDistance().equals(distance))
                .map(c -> c.getName().getName())
                .collect(Collectors.toList());
    }
}
