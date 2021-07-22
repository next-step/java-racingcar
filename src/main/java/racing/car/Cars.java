package racing.car;

import util.RandomUtils;

import java.util.*;

public class Cars implements Iterable<Car> {
    private final List<Car> values;

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

    private Distance randomDistance() {
        int randomValue = RandomUtils.nextInt(9);
        return Distance.newInstance(
                randomValue >= 4 ? randomValue : DistanceRange.NOT_MOVEMENT_VALUE
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
