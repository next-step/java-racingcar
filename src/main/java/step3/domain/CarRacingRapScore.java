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

}
