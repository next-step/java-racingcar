package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
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

    public List<Car> getCars() {
        return cars;
    }

    private static List<Car> createCars(int count) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            cars.add(new Car());
        }
        return cars;
    }


    private void validate(int carCount) {
        if (carCount <= 0) {
            throw new IllegalArgumentException("자동차 대수는 음수가 불가능합니다.");
        }
    }

    public void moveCars(RandomMoveStrategy strategy) {
        for (int j = 0; j < cars.size(); j++) {
            tryMove(strategy, cars.get(j));
        }
    }

    private void tryMove(RandomMoveStrategy strategy, Car car) {
        car.moveForward(strategy);
    }


    public List<Integer> getPositions() {
        return cars.stream()
                .map(car -> car.getPosition().getValue())
                .toList();
    }


}
