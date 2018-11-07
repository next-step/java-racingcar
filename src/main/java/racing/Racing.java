package racing;

import racing.domain.Car;
import racing.rule.IForward;
import racing.utils.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Racing implements Game {

    private final int TRY_END_COUNT;

    private int tryCount;
    private final List<Car> cars = new ArrayList<>();
    private final IForward forward;

    public Racing(final String names, final int tryCount, final IForward forward) {

        this.TRY_END_COUNT = 0;
        this.tryCount = tryCount;
        this.forward = forward;

        Arrays.stream(StringUtils.split(names, ",")).forEach(name -> cars.add(new Car(name, this.forward)));
    }

    @Override
    public boolean hasTryCount() {
        return tryCount > this.TRY_END_COUNT;
    }

    @Override
    public void start() {
        decreaseTryCount();
        cars.forEach(Car::run);
    }

    private void decreaseTryCount() {
        tryCount--;
    }

    @Override
    public List<Car> getCars() {
        return cars;
    }

}
