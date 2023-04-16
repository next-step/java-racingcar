package car;

import game.CarDto;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<String> names) {
        List<Car> cars = names.stream()
                .map(name -> new Car(name, new RandomMoveStrategy()))
                .collect(Collectors.toList());

        return new Cars(cars);
    }

    public void move() {
        for(Car car: cars) {
            car.move();
        }
    }

    public List<Car> winners() {
        Position maxPosition = maxPosition();

        return cars.stream()
                .filter(car -> car.isWinner(maxPosition))
                .collect(Collectors.toList());
    }

    private Position maxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Position::compareTo)
                .orElse(new Position());
    }

    public List<CarDto> getCurrentResult() {
        return cars.stream()
                .map(CarDto::from)
                .collect(Collectors.toList());
    }
}
