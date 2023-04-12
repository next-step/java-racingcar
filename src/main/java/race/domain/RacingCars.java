package race.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCars {

    private final List<Car> cars = new ArrayList<>();

    public RacingCars(String[] names) {
        addCars(names);
    }

    public List<Car> getList() {
        return cars;
    }

    private void addCars(String[] names) {
        Arrays.stream(names).forEach(name -> cars.add(new Car(name)));
    }
}
