package race;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private String name;
    private final List<Integer> distance = new ArrayList<>();
    private static final int FORWARD = 1;
    private static final int STOP = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(boolean isMove) {
        if (isMove) {
            distance.add(FORWARD);
            return;
        }
        distance.add(STOP);
    }

    public int getDistance(int tryCount) {
        return (int) distance.stream()
                .limit(tryCount)
                .filter(i -> i == FORWARD)
                .count();
    }

    public int getTotalDistance() {
        return (int) distance.stream()
                .filter(i -> i == FORWARD)
                .count();
    }

    public String getName() {
        return this.name;
    }

    public List<Integer> getDistance() {
        return this.distance;
    }

}
