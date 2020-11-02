package step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(Integer carCount) {
        cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car(0));
        }
    }

    public Cars(List<Integer> positions) {
        cars = new ArrayList<>();
        for (Integer position : positions) {
            cars.add(new Car(position));
        }
    }

    public void move() {
        for (Car car : cars) {
            RacingStrategy.move(car);
        }
    }

    public Integer size() {
        return cars.size();
    }

    public List<Integer> getPositions() {
        return cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
    }
}
