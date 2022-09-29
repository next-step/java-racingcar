package game.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {

    private final List<Car> carList;

    public Cars(int countOfCar) {
        this.carList = IntStream.range(0, countOfCar)
                .mapToObj(i -> new Car())
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
