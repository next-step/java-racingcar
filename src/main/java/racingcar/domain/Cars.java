package racingcar.domain;

import java.util.*;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        assertNotEmptyAndNullCars(cars);
        assertNotDuplicateCars(cars);

        this.cars = cars;
    }

    public List<Car> getCars() {
        List<Car> copyCars = new ArrayList<>();

        for (Car car : cars) {
            copyCars.add(new Car(car));
        }

        return copyCars;
    }

    public void move(MoveCommand moveCommand) {
        for (Car car : cars) {
            car.move(moveCommand.command());
        }
    }

    public List<Car> getWinnerCars() {
        Car winnerCar = Collections.max(cars);
        int winPosition = winnerCar.getPosition();

        List<Car> winnerCars = new ArrayList<>();
        for (Car car : cars) {
            isWinnerCar(car, winPosition).ifPresent(winnerCars::add);
        }

        return winnerCars;
    }

    private Optional<Car> isWinnerCar(Car car, int winPosition) {
        if (car.getPosition() == winPosition) {
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
