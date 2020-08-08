package step3.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacingRapScore {

    private List<Car> cars;

    public CarRacingRapScore(List<Car> cars) {
        this.cars = Collections.unmodifiableList(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> findBestScoreCars() {
        int bestScore = cars.stream().map(Car::getPosition).max(Integer::compareTo).get();
        return cars.stream().filter(car -> car.getPosition() == bestScore).collect(Collectors.toList());
    }

}
