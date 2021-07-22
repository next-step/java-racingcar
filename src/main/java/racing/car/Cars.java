package racing.car;

import util.RandomUtils;

import java.util.*;

public class Cars implements Iterable<Car> {
    private static final Random random = new Random();
    private List<Car> values;

    public Cars() {
        this.values = new ArrayList<>();
    }

    public void moveAll(boolean movement) {
        if (!movement)
            return;
        for (Car iCar : values) {
            iCar.move(randomDistance());
        }
    }

    private Location randomDistance() {
        int randomValue = RandomUtils.nextInt(9);
        return new Location(
                randomValue >= 4 ? randomValue : Car.MovementDistance.NOT_MOVEMENT_VALUE.getValue()
        );
    }

    public void add(Car car) {
        values.add(car);
    }

    public int size() {
        return values.size();
    }

    @Override
    public Iterator<Car> iterator() {
        return values.iterator();
    }
}
