package step4.model;

import javax.swing.*;

public class CarMoving implements Moving {
    private final static Integer MINIMAL_MOVABLE_NUMBER = 4;

    private int distance;

    public CarMoving() {
        this(0);
    }

    public CarMoving(int distance) {
        this.distance = distance;
    }

    public void move(NumberGenerator generator) {
        if (generator.generate() > MINIMAL_MOVABLE_NUMBER) {
            distance++;
        }
    }

    public String getDistanceStr(String move) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            result.append(move);
        }
        return result.toString();
    }

    public int getDistance() {
        return distance;
    }
}
