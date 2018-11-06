package racing;

import racing.rule.IForward;
import racing.utils.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Racing implements Game {

    private final int TRY_END_COUNT;

    private int tryCount;
    private final List<Car> list = new ArrayList<>();

    public Racing(final String carRacers, final int tryCount, final IForward forward) {
        this.TRY_END_COUNT = 0;
        this.tryCount = tryCount;
        Arrays.asList(StringUtils.split(carRacers, ",")).forEach(carRacer -> list.add(new Car(new CarRacer(carRacer), forward)));
    }

    @Override
    public boolean hasTryCount() {
        return tryCount > this.TRY_END_COUNT;
    }

    @Override
    public void start() {
        decreaseTryCount();
        list.forEach(Car::run);
    }

    private void decreaseTryCount() {
        tryCount--;
    }

    @Override
    public List<Car> getList() {
        return list;
    }

}
