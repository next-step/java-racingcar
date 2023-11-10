package racing;

import java.util.Random;

public class Car {
    private static final String DISTANCE_STRING = "-";

    private String name;
    private int distance;

    public Car() { }

    public Car(String name) {
        checkName(name);
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    private void checkName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
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
