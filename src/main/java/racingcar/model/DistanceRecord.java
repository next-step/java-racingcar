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
        this.distanceRecord.add(distance);
    }

    public Integer getDistance(int index) {
        return this.distanceRecord.get(index);
    }

    public int size() {
        return this.distanceRecord.size();
    }

    @Override
    public Iterator iterator() {
        return this.distanceRecord.iterator();
    }
}
