package racingcar;

import racingcar.exception.NotYetMovedException;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public int size() {
        return cars.size();
    }

    public Car get(int index) {
        return cars.get(index);
    }

    public List<String> getLeaders() {
        int maxPosition = getMaxPosition();

        return cars.stream()
                .filter(p -> p.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .sorted()
                .findFirst()
                .orElseThrow(NotYetMovedException::new)
                .getPosition();
    }
}
