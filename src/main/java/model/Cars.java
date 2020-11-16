package model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars (List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> stepForward () {
        cars.forEach(car -> car.stepForward(new RandomMovingStrategy()));
        return cars;
    }

    public void printCars () {
        cars.forEach(Car::printCar);
    }

    public Position getMaxPosition () {
        Position maxPosition = new Position(0);

        for (Car car : cars) {
            maxPosition = car.getMaxPosition(maxPosition);
        }

        return maxPosition;
    }

    public List<Car> getWinners () {
        List<Car> winners;

        Position maxPosition = getMaxPosition();
        winners = cars.stream().filter(car -> car.isWinner(maxPosition)).collect(Collectors.toList());

        return winners;
    }

    public void printWinners () {
        for (Car car : cars) {
            car.printName();
            System.out.print(" ");
        }

        System.out.println("가 최종 우승했습니다.");
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode () {
        return Objects.hash(cars);
    }
}
