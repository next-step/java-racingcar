package step4;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public class CarAssembler {
    private List<Car> cars;
    private static final String DEFAULT_RACING_RESULT = "";

    public CarAssembler(String[] splitCarName) {
        this.cars = createUsers(splitCarName);
    }

    public List<Car> createUsers(String[] splitCarName) {
        return Arrays.stream(splitCarName)
                     .map(carName -> new Car(carName, DEFAULT_RACING_RESULT))
                     .collect(toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}
