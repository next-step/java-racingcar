package racing.domain;

public class Car {
    private static final int MOVE_CONDITION = 4;

    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void move(int randomValue) {
        if (MOVE_CONDITION <= randomValue) {
            this.distance++;
        }
    }
}
