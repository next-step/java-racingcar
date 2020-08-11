package step4.model;

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
        return distance.get(i);
    }

    public void moveForward() {
        int lastScore = distance.get(distance.size() - 1);
        distance.add(lastScore + 1);
    }

    public void stop() {
        int lastScore = distance.get(distance.size() - 1);
        distance.add(lastScore);
    }
}
