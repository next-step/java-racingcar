package racingGame;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void start(RandomNumber randomNumber) {
        cars.forEach(car -> car.start(randomNumber));
    }

    public Positions getPositions() {
        List<Position> positionList = cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
        return new Positions(positionList);
    }
}
