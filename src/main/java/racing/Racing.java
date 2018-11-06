package racing;

import racing.rule.IForward;
import racing.utils.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Racing implements Game {

    private final int TRY_END_COUNT;

    private int tryCount;
    private List<Car> list;

    public Racing(final List<Car> list, final int tryCount) {
        this.TRY_END_COUNT = 0;
        this.tryCount = tryCount;
        this.list = list;
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
