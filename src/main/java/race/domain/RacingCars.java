package race.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import race.util.RandomNumber;

public class RacingCars {

    private final List<Car> cars = new ArrayList<>();

    public RacingCars(String[] names) {
        addCars(names);
    }

    public void race() {
        cars.forEach(car -> car.move(RandomNumber.get()));
    }

    public List<Car> getList() {
        return cars;
    }

    private void addCars(String[] names) {
        Arrays.stream(names).forEach(name -> cars.add(new Car(name)));
    }
}
