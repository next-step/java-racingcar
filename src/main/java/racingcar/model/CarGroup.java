package racingcar.model;

import racingcar.ValueGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarGroup {
    private final List<Car> cars;

    public CarGroup(List<Car> cars) {
        this.cars = cars;
    }

    public static List<Car> createCars(int carNumber) {
        validateNumber(carNumber);
        List<Car> cars = new ArrayList<>();
        for (int i = 1; i <= carNumber; i++) {
            cars.add(new Car(0));
        }
        return cars;
    }

    private static void validateNumber(int number) {
        if (number < 0) {
            throw new RuntimeException("음수 값은 허용하지 않습니다.");
        }
    }

    public void moveCarGroup(int trialNumber) {
        validateNumber(trialNumber);
        for (int i = 0; i < trialNumber; i++) {
            moveCarPerTrial();
        }
    }

    private void moveCarPerTrial() {
        for (Car car : this.cars) {
            car.tryToMove(ValueGenerator.generateRandomValue());
        }
    }

    public List<List<Integer>> getCarMoveDistanceTrace() {
        return this.cars.stream().map(Car::getMoveDistanceTrace).collect(Collectors.toList());
    }
}
