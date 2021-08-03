package racingcar.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Distances implements Iterable<Distance> {
    private final List<Distance> distances = new ArrayList<>();

    @Override
    public Iterator<Distance> iterator() {
        return distances.iterator();
    }
}
