package carracing.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarList {
    public static final String DELIMITER = ",";

    private final List<Car> cars = new ArrayList<>();

    public CarList(String carNameString) {
        List<String> names = splitString(carNameString);
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    private List<String> splitString(String carNameString) {
        return Arrays.asList(carNameString.split(DELIMITER));
    }

    public List<String> playOneRound(NumberGenerator randomNumberGenerator) {
        List<String> result = new ArrayList<>();
        for (Car car : cars) {
            car.move(randomNumberGenerator.generateNumber());
            result.add(car.makeDistanceString());
        }
        return result;
    }

    public List<Car> findWinners() {
        int maxDistance = maxCarDistance();
        return cars.stream()
                .filter(c -> c.hasSameDistance(maxDistance))
                .collect(Collectors.toList());
    }

    private int maxCarDistance() {
        int maxDistance = 0;
        for (Car car : cars) {
            maxDistance = car.returnMaxDistance(maxDistance);
        }
        return maxDistance;
    }
}
