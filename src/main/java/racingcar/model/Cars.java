package racingcar.model;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Cars {

    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = Collections.unmodifiableList(carList);
    }

    public void move(List<Integer> moveCounts) {
        for (int index = 0; index < carList.size(); index++) {
            Car car = carList.get(index);
            car.move(moveCounts.get(index));
        }
    }

    public List<CarName> getWinners() {
        int maxMovement = getMaxMovement();
        return carList.stream()
                .filter(car -> car.isMaxMovement(maxMovement))
                .map(Car::getCarName)
                .collect(toList());
    }

    private int getMaxMovement() {
        return carList.stream()
                .max(Car::isForwardLocationThan)
                .orElseThrow()
                .getCurrentLocationValue();
    }

    public int size() {
        return carList.size();
    }
}
