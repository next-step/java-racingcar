package racing;

import java.util.Random;

public class Car {
    private static final String DISTANCE_STRING = "-";

    private String name;
    private int distance = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public void move() {
        Random random = new Random();
        if (random.nextInt(10) >= 4) {
            distance++;
        }
    }

    public void move(int n) {
        if (n >= 4) {
            distance++;
        }
    }

    public void showDistance() {
        if (this.name.isEmpty()) {
            ResultView.print(DISTANCE_STRING.repeat(distance));
            return;
        }
        ResultView.print(this.name + " : " + DISTANCE_STRING.repeat(distance));
    }
}
