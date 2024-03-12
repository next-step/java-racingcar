package racingcar.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DistanceRecord implements Iterable<Integer>{
    private final List<Integer> distanceRecord;

    public DistanceRecord() {
        this.distanceRecord = new ArrayList<>();
    }

    public void add(Integer distance) {
        distanceRecord.add(distance);
    }

    @Override
    public Iterator iterator() {
        return distanceRecord.iterator();
    }
}
