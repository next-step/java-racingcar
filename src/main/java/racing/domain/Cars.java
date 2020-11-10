package racing.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> moves(RaceRule raceRule) {
        return cars.stream()
                .map(car -> car.move(raceRule))
                .collect(Collectors.toList());
    }

}
