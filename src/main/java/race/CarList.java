package race;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarList {
    private final Random random = new Random();

    private final List<RacingCar> cars;

    public CarList() {
        this(new ArrayList<>());
    }

    public CarList(List<RacingCar> cars) {
        this.cars = cars;
    }

    public void add(RacingCar car) {
        cars.add(car);
    }

    public void moveWithRandom() {
        for (RacingCar car : cars) {
            car.moveWithSeed(random.nextInt());
        }
    }

    public List<RacingCar> getList() {
        return cars;
    }
}
