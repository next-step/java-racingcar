package racingcar.model;

import racingcar.pattern.ValueGenerateStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarGroup {
    private final List<Car> cars;

    public CarGroup(List<Car> cars) {
        this.cars = cars;
    }

    public static List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNames.size(); i++) {
            cars.add(new Car(0, carNames.get(i)));
        }
        return cars;
    }

    public void moveCarGroup(PositiveNumber trialNumber, ValueGenerateStrategy valueGenerateStrategy) {
        for (int i = 0; i < trialNumber.getNumber(); i++) {
            moveCarGroupPerTrial(valueGenerateStrategy);
        }
    }

    private void moveCarGroupPerTrial(ValueGenerateStrategy valueGenerateStrategy) {
        for (Car car : this.cars) {
            car.tryToMove(valueGenerateStrategy);
        }
    }

    public List<Identity> getWinners() {
        Integer maxDistance = getMaxDistance();

        return this.cars.stream()
                .filter(car -> car.getMoveDistance().getNumber() == maxDistance)
                .map(Car::getId)
                .collect(Collectors.toList());
    }

    private Integer getMaxDistance() {
        return this.cars.stream().mapToInt(car -> car.getMoveDistance().getNumber()).max().getAsInt();
    }
}
