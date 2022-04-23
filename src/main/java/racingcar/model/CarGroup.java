package racingcar.model;

import racingcar.pattern.ValueGenerateStrategy;
import racingcar.util.SplitString;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CarGroup {
    private final List<Car> cars;

    public CarGroup(String carNameText) {
        List<String> carNames = SplitString.split(carNameText);
        List<Car> cars = new ArrayList<>();
        carNames.forEach(carName -> cars.add(new Car(0, carName)));
        this.cars = cars;
    }

    public CarGroup(List<Car> cars) {
        this.cars = cars;
    }

    void moveCarGroupPerTrial(ValueGenerateStrategy valueGenerateStrategy) {
        for (Car car : this.cars) {
            car.tryToMove(valueGenerateStrategy);
        }
    }

    public List<String> getNames() {
        return this.cars.stream().map(Car::getName).collect(Collectors.toList());
    }

    public List<String> getWinners() {
        int maxDistance = getMaxDistance();

        return this.cars.stream()
                .filter(car -> car.isWinner(maxDistance))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxDistance() {
        int maxDistance = 0;
        for (Car car : this.cars) {
            maxDistance = car.maxDistance(maxDistance);
        }
        return maxDistance;
    }

    public Map<String, Integer> getCarMap() {
        return this.cars.stream().collect(Collectors.toMap(Car::getName, Car::getMoveDistance));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarGroup carGroup = (CarGroup) o;

        return cars != null ? cars.equals(carGroup.cars) : carGroup.cars == null;
    }

    @Override
    public int hashCode() {
        return cars != null ? cars.hashCode() : 0;
    }
}
