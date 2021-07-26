package racing.model;

import java.util.ArrayList;
import java.util.List;

public class CarModel {
    private static final int moveValue = 1;
    private List<Integer> distance;

    public CarModel() {
        this.distance = new ArrayList<>();
    }

    public void go() {
        this.distance.add(moveValue);
    }

    public int totalDistance() {
        return distance.stream().mapToInt(Integer::intValue).sum();
    }
}
