package carracing.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    public Cars(String carNames) {
        Arrays.stream(carNames.split(","))
                .map(Car::new)
                .forEach(cars::add);
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void play() {
        cars.stream().forEach(car -> car.move(new RandomMoveStrategy()));
    }

    public List<String> getWinners() {
        return cars.stream()
                .filter(car -> car.isWinner(getMaxScore()))
                .map(Car::getName)
                .map(Name::getName)
                .collect(Collectors.toList());
    }

    private int getMaxScore() {
        return cars.stream()
                .map(Car::getPosition)
                .reduce(0, Math::max);
    }
}
