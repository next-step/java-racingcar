package step5.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import step5.view.CarDTO;

public class Cars {

    private final List<Car> cars;

    public Cars(final String[] carNames) {
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName, new RandomMoveStrategy()));
        }
    }

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public List<CarDTO> getCars() {
        return cars.stream()
            .map(CarDTO::new)
            .collect(Collectors.toList());
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public Cars getWinners() {
        return new Cars(getWinners(getWinnerPos()));
    }

    private Position getWinnerPos() {
        return cars.stream()
            .map(Car::getPosition)
            .max(Position::compareTo)
            .get();
    }

    private List<Car> getWinners(Position winnerPos) {
        return cars.stream()
            .filter(car -> car.isWinner(winnerPos))
            .collect(Collectors.toList());
    }
}
