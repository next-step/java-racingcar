package newRacingCar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> findWinners() {
        List<Car> winners = new ArrayList<>();
        Position maxPosition = maxPositionCar();
        for (Car car : cars) {
            if (car.getPosition().isSamePosition(maxPosition)) {
                winners.add(car);
            }
        }
        return winners;
    }

    public Position maxPositionCar() {
        Position position = new Position(0);
        for (Car car : cars) {
            if (position.isMaxPosition(car.getPosition())) {
                position = car.getPosition();
            }
        }
        return position;
    }

    public void move() {
        for (Car car : cars) {
            car.move(new RandomMoveStrategy());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}