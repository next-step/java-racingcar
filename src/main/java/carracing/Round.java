package carracing;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Round {
    private final Map<CarName, Integer> nameToStep;

    public Round(List<Car> cars) {
        nameToStep = new HashMap<>();
        cars.forEach(car -> {
            nameToStep.put(car.getCarName(), car.getStep());
        });
    }

    public int getStep(String carName) {
        return nameToStep.get(new CarName(carName));
    }

    public Map<CarName, Integer> getSteps() {
        return Collections.unmodifiableMap(nameToStep);
    }
}
