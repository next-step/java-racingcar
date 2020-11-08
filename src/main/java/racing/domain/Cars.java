package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public void setCars(int vehicleCount) {
        for(int i = 0; i<vehicleCount; i += 1) {
            cars.add(new Car(String.valueOf(i)));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> moves(RaceRule raceRule) {
        return cars.stream()
                .peek(car -> car.move(raceRule))
                .collect(Collectors.toList());
    }

}
