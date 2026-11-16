package racingcar.domain;

import java.util.ArrayList;

import java.util.List;

public class Cars {

    private final List<Car> cars;

    private Cars(int carCount) {
        validate(carCount);
        this.cars = createCars(carCount);
    }


    public static Cars create(int carCount) {
        return new Cars(carCount);
    }

    private static List<Car> createCars(int count) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            cars.add(new Car());
        }
        return cars;
    }


    public void moveCars(RandomMoveStrategy strategy) {
        for (Car car : cars) {
            car.moveForward(strategy);
        }
    }

    public List<Integer> getPositions() {
        return cars.stream()
                .map(car -> car.getPosition().getValue())
                .toList();
    }

    private void validate(int carCount) {
        if (carCount <= 0) {
            throw new IllegalArgumentException("자동차 대수는 음수가 불가능합니다.");
        }
    }


}
