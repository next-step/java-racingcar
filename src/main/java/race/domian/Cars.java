package race.domian;

import race.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(List<String> names) {
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public void move(MoveStrategy moveStrategy) {
        for (Car car : cars) {
            car.move(moveStrategy);
        }
    }

   public List<String> findWinners() {
       final Car maxPositionCar = findMaxPositionCar();
       return findSamePositionCars(maxPositionCar);
    }

    private List<String> findSamePositionCars(Car maxPositionCar) {
        return cars.stream()
                .filter(maxPositionCar::isSamePosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private Car findMaxPositionCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("차량 리스트가 비었습니다."));
    }

    public List<Integer> getPosition() {
        return cars.stream()
            .map(Car::getPosition)
            .collect(Collectors.toList());
    }

    public List<String> getNames() {
        return cars.stream()
            .map(Car::getName)
            .collect(Collectors.toList());
    }
}
