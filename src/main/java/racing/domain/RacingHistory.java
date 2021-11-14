package racing.domain;

import java.util.*;

/**
 * @author han
 */
public class RacingHistory {

    private Queue<List<Car>> data;

    public RacingHistory() {
        this.data = new LinkedList<>();
    }

    public Queue<List<Car>> getData() {
        return data;
    }

    public boolean hasData() {
        return !this.data.isEmpty();
    }

    public List<Car> poll() {
        return this.data.poll();
    }

    public void add(List<Car> cars) {
        this.data.add(cars);
    }
}

