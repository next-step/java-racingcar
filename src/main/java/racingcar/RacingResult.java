package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingResult {

    private List<Car> cars;

    public RacingResult(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();

        return cars.stream()
            .filter(car -> car.comparePosition(maxPosition) == 0)
            .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        int maxPosition = cars.get(0).getPosition();

        for(Car car : cars) {
            if(car.comparePosition(maxPosition) > 0) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    public List<Car> getCars() {
        return cars;
    }
}
