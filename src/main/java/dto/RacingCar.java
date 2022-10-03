package dto;

import java.util.Random;

public class RacingCar {
    private int distance;
    private String name;

    public RacingCar(int distance) {
        this.distance = distance;
    }

    public RacingCar(int distance, String name) {
        if (name.length() > 5) throw new IllegalStateException("이름은 5자를 넘길 수 없습니다.");

        this.distance = distance;
        this.name = name;
    }

    public int move(int speed) {
        if (speed < 4) return 0;
        distance += 1;
        return distance;
    }

    public int speedOf() {
        Random random = new Random();

        return random.nextInt(10);
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }
}