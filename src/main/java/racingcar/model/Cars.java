package racingcar.model;

import racingcar.util.RandomNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveCars() {
        cars.forEach(car -> car.move(RandomNumber.generate()));
    }

    public String findWinner() {
        List<Car> sortedCars = new ArrayList<>(cars);

        Collections.sort(sortedCars, (o1, o2) -> o2.getPosition() - o1.getPosition());

        int highScore = sortedCars.get(0).getPosition();

        return sortedCars.stream()
                .filter(car -> highScore == car.getPosition())
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
