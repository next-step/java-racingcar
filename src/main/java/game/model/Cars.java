package game.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> carList;

    public Cars(List<String> carNames) {
        this.carList = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void moveCarList(MovableStrategy movableStrategy) {
        for (Car v : this.carList) {
            v.move(movableStrategy);
        }
    }

    public List<Car> getCarList() {
        return Collections.unmodifiableList(carList);
    }
}
