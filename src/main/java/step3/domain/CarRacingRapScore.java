package step3.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarRacingRapScore {

    private List<Car> cars;

    public CarRacingRapScore(List<Car> cars) {
        this.cars = cars.stream().map(Car::clone).collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> findBestScoreCars() {
        int bestScore = cars.stream().map(Car::getPosition).max(Integer::compareTo).get();
        return cars.stream().filter(car -> car.getPosition() == bestScore).collect(Collectors.toList());
    }

}
