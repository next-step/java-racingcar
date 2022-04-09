package racingcar;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Cars {

    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = Collections.unmodifiableList(carList);
    }

    public List<CarLocationResult> move(List<Integer> moveCounts) {
        for (int index = 0; index < carList.size(); index++) {
            Car car = carList.get(index);
            car.move(moveCounts.get(index));
        }

        return getCarLocationResult();
    }

    private List<CarLocationResult> getCarLocationResult() {
        return carList.stream()
                .map(CarLocationResult::from)
                .collect(toList());
    }

    public List<CarName> getWinners() {
        int maxMovement = getMaxMovement();
        return carList.stream()
                .filter(car -> car.getCurrentLocation() == maxMovement)
                .map(car -> new CarName(car.getCarName()))
                .collect(toList());
    }

    private int getMaxMovement() {
        return carList.stream()
                .max(Comparator.comparingInt(Car::getCurrentLocation))
                .orElseThrow()
                .getCurrentLocation();
    }

    public int size() {
        return carList.size();
    }
}
