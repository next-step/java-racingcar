package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        assertNotEmptyAndNullCars(cars);
        assertNotDuplicateCars(cars);

        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars.stream().map(Car::new).collect(Collectors.toUnmodifiableList());
    }

    public void move(MoveCommand moveCommand) {
        for (Car car : cars) {
            car.move(moveCommand.command());
        }
    }

    public List<Car> getWinnerCars() {
        Car winnerCar = Collections.max(cars);
        Position winPosition = winnerCar.getPosition();

        return cars.stream().filter(car ->
                        isWinnerCar(car, winPosition).isPresent()
                )
                .map(Car::new)
                .collect(Collectors.toUnmodifiableList());
    }

    private Optional<Car> isWinnerCar(Car car, Position winPosition) {
        Position carPosition = car.getPosition();
        if (winPosition.equals(carPosition)) {
            return Optional.of(new Car(car));
        }

        return Optional.empty();
    }

    private void assertNotEmptyAndNullCars(List<Car> cars) {
        String errorMessage = "차량을 입력해주세요";
        if (cars == null) {
            throw new NullPointerException(errorMessage);
        }
        if (cars.isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private void assertNotDuplicateCars(List<Car> cars) {
        String errorMessage = "중복된 이름의 차량이 있습니다.";
        Set<Car> uniqueCar = Set.copyOf(cars);

        if (uniqueCar.size() != cars.size()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

}
