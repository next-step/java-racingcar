package domain;

import dto.CarDto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingResult {

    private List<CarDto> results = new ArrayList<>();

    public RacingResult(List<Car> cars) {
        for (Car car : cars) {
            results.add(new CarDto(car.getCarName().getName(), car.getPosition().getPosition()));
        }
    }

    public List<CarDto> getResults() {
        return Collections.unmodifiableList(results);
    }
}
