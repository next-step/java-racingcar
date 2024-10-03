package racinggame.modal.collection;

import racinggame.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> carList;

    public Cars(List<String> carNames) {
        this.carList = new ArrayList<>();
        initCar(carNames);
    }

    private void initCar(List<String> carNames) {
        for (String carName : carNames) {
            carList.add(Car.create(carName));
        }
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
