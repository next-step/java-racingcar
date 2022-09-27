import java.util.Random;

public class Car {
    private int distance;

    public Car(int distance) {
        this.distance = distance;
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
}
