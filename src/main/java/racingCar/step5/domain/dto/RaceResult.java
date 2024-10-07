package racingCar.step5.domain.dto;

import java.util.ArrayList;
import java.util.List;

public class RaceResult {
    private List<CarDto> cars;

    public RaceResult() {
        cars = new ArrayList<>();
    }

    public void add(CarDto car) {
        cars.add(car);
    }

    public List<CarDto> getCars() {
        return cars;
    }
}
