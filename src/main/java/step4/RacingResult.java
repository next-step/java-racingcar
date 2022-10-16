package step4;

import java.util.ArrayList;
import java.util.List;

public class RacingResult {

    private List<Car> results = new ArrayList<>();

    public RacingResult(List<Car> cars) {
        for (Car car : cars) {
            results.add(new Car(car.getName(), car.getDistance()));
        }
    }

    public List<Car> getResults() {
        return results;
    }
}
