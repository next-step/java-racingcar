package carRace.domain.car;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarGroup {

    private final List<Car> carGroup;

    public CarGroup(List<Car> carGroup) {
        this.carGroup = carGroup;
    }

    public CarGroup(final CarNames carNames) {
        this.carGroup = IntStream.range(0, carNames.getCarNames().size())
            .mapToObj(carNumber -> new Car(carNames.getCarNames().get(carNumber)))
            .collect(Collectors.toList());
    }

    public List<Car> getCarGroup() {
        return carGroup.stream()
            .map(Car::new) // 각 Car 객체를 복사하여 새로운 객체 생성
            .collect(Collectors.toList());
    }

    public Car findWinningCar() {
        return carGroup.stream()
            .max(Car::compareTo)
            .orElseThrow(NoSuchElementException::new);
    }

    public CarNames findCarNames(Car winningCar) {
        List<CarName> carNames = carGroup.stream()
            .filter(car -> car.isSameMoveDistance(winningCar.getMoveDistance()))
            .map(Car::getCarName)
            .collect(Collectors.toList());
        return new CarNames(carNames);
    }
}
