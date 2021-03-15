package study.step5.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void addCar(Car car) {
        this.cars.add(car);
    }

    public void run(MovingStrategy movingStrategy) {
        cars.forEach(car -> car.move(movingStrategy));
    }

    public List<Car> findWinners() {
        return getWinners(getMaxPosition());
    }

    private List<Car> getWinners(Position maxPosition) {
        List<Car> winners = new ArrayList<>();

        cars.forEach(car -> addWinner(winners, car, maxPosition));
        /*
        return cars.stream()
            .filter(car -> maxPosition.equals(car.getPosition()))
            .collect(Collectors.toList());
        */
        return winners;
    }

    private void addWinner(List<Car> winner, Car car, Position maxPosition) {
        if(!car.getPosition().lessThan(maxPosition)) {
            winner.add(car);
        }
    }

    private Position getMaxPosition() {
        Position maxPosition = new Position(0);
        for(Car car : cars) {
            maxPosition = car.getMaxPosition(maxPosition);
        }
        return maxPosition;
    }
}
