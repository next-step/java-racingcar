package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(String[] names) {
        this(Arrays.stream(names).map(Car::new).collect(Collectors.toList()));
    }

    public Cars deepCopy() {
        List<Car> copyCars = new ArrayList<>();
        for (Car car : this.cars) {
            copyCars.add(new Car(car));
        }
        return new Cars(copyCars);
    }

    public List<Car> get() {
        return Collections.unmodifiableList(cars);
    }

    public int size() {
        return this.cars.size();
    }

    public void move(CarMoveStrategy moveStrategy) {
        for (Car car : this.cars) {
            car.move(moveStrategy);
        }
    }

    public Winners getWinners() {
        Distance winDistance = findWinDistance();
        return findWinners(winDistance);
    }

    public Distance findWinDistance() {
        Distance winDistance = new Distance();
        for (Car car : this.cars) {
            winDistance = winDistance.max(car.getDistance());
        }
        return winDistance;
    }

    private Winners findWinners(Distance winDistance) {
        Winners winners = new Winners();
        for (Car car : this.cars) {
            winners.add(car, winDistance);
        }
        return winners;
    }

}
