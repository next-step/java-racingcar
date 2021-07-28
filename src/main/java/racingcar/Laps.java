package racingcar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Laps implements Iterable<Lap> {
    private List<Lap> laps = new ArrayList<>();

    public void record(Cars cars) {
        laps.add(new Lap(cars));
    }

    @Override
    public Iterator<Lap> iterator() {
        return laps.iterator();
    }
}
