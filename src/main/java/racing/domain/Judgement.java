package racing.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Judgement {

    private final Cars cars;

    public Judgement(Cars cars){
        this.cars = cars;
    }

    public List<Car> getWinnerCars() {

        return cars.getCars()
                .stream()
                .filter(car -> car.isSamePosition(getMaxPosition()))
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        int maxPosition = 0;

        for (Car car : cars.getCars()) {
            maxPosition = car.max(maxPosition);
        }

        return maxPosition;
    }
}
