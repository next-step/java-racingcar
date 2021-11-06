package racingcar.service.model;

import racingcar.service.domain.Car;
import racingcar.utils.Preconditions;
import racingcar.service.value.Position;
import racingcar.service.value.Round;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Record {
    private final Round round;
    private final List<Car> cars;

    private Record(Round round, List<Car> cars) {
        Preconditions.checkNotNull(round, "round는 필수값입니다.");
        Preconditions.checkNotNull(cars, "cars는 필수값입니다.");

        this.round = round;
        this.cars = cars;
    }

    public static Record of(Round round, List<Car> cars) {
        return new Record(round, clone(cars));
    }

    private static List<Car> clone(List<Car> originCars) {
        return originCars.stream()
                .map(Car::clone)
                .collect(Collectors.toList());
    }

    public String getRoundWinnerName() {
        Position maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.currentPosition().equals(maxPosition))
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    private Position getMaxPosition() {
        return cars.stream()
                .map(Car::currentPosition)
                .max(Comparator.comparingInt(Position::getPosition))
                .orElseThrow(NoSuchElementException::new);
    }

    public Integer getCurrentRound() {
        return round.getRound();
    }

    public List<Car> getCars() {
        return cars;
    }
}
