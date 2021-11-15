package racing.domain;

import java.util.*;

/**
 * @author han
 */
public class RacingHistory {

    private Queue<RacingCar> data;

    private RacingHistory() {
        this.data = new LinkedList<>();
    }

    public static RacingHistory getInstance() {
        return new RacingHistory();
    }

    // for test
    public Queue<RacingCar> getData() {
        return data;
    }

    public boolean hasData() {
        return !this.data.isEmpty();
    }

    public RacingCar poll() {
        return this.data.poll();
    }

    public void add(RacingCar cars) {
        this.data.add(cars);
    }
}

