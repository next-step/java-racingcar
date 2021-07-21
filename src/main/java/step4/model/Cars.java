package step4.model;

import step4.move.MovableStrategy;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    static public Cars of(String names) {
        String[] nameArr = splitNames(names);
        AtomicInteger index = new AtomicInteger();

        return new Cars(
            Stream.generate(() -> new Car(nameArr[index.getAndIncrement()]))
                .limit(nameArr.length)
                .collect(Collectors.toList())
        );
    }

    static public String[] splitNames(String name) {
        return name.split(",");
    }

    public void move(MovableStrategy movableStrategy) {
        cars.forEach(car -> car.move(movableStrategy));
    }

    public int countOfCars() {
        return cars.size();
    }

    public List<PointOfCar> getPointOfTime(int time) {
        return cars.stream()
            .map(car -> car.getPointOfTime(time))
            .collect(Collectors.toList());
    }
}
