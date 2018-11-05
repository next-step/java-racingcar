package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Racing implements Game {

    private final int TRY_END_COUNT;

    private int tryCount;

    private final List<Car> list = new ArrayList<>();

    public Racing(final int carCount, final int tryCount) {
        this.TRY_END_COUNT = 0;
        this.tryCount = tryCount;
        IntStream.range(0, carCount).forEachOrdered(i -> list.add(new Car()));
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

    @Override
    public List<Car> getList() {
        return list;
    }

    private void decreaseTryCount() {
        tryCount--;
    }

}
