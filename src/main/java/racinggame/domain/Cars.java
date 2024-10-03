package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> carList;

    public Cars() {
        this.carList = new ArrayList<>();
    }

    public void add(Car car) {
        carList.add(car);
    }

    public List<Car> getCarList() {
        return carList;
    }

    public int getMaxPosition() {
        return carList.stream()
                .reduce(0,
                        (maxPosition, car) -> car.comparePosition(maxPosition),
                        Math::max
                );
    }
}
