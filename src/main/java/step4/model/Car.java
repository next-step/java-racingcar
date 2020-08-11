package step4.model;

import step4.strategy.MovementStrategy;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private final String carName;
    private final List<Integer> distance;

    public Car(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException();
        }
        this.carName = carName;

        this.distance = new ArrayList<>();
        distance.add(0);
    }

    public String getCarName() {
        return this.carName;
    }

    public int getScore(int i) {
        return this.distance.get(i);
    }

    public List<Integer> getAllRecords() {
        return distance;
    }

    public void moveWithStrategy(MovementStrategy strategy) {
        int lastScore = distance.get(distance.size() - 1);
        distance.add(strategy.doAction(lastScore));
    }
}
