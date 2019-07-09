package racing.model;

import java.util.ArrayList;
import java.util.List;

public class Result {

    List<String> results = new ArrayList<>();

    public void collect(Cars cars) {
        cars.getCars().forEach(car -> results.add(car.getName() + ":" + car.getDistance()));
        results.add("");
    }

    public List<String> getResults() {
        return results;
    }
}
