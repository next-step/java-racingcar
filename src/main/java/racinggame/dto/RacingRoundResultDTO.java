package racinggame.dto;

import racinggame.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingRoundResultDTO {

    private final List<Car> cars;

    public RacingRoundResultDTO(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public List<Car> getCars() {
        return cars;
    }
}
