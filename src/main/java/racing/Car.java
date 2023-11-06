package racing;

public class Car {

    public static final int FORWARD_CONDITION = 4;
    private final int number;
    private int distance;

    public Car(int number) {
        this.number = number;
        this.distance = 0;
    }

    public int carNumber() {
        return number;
    }

    public int carDistance() {
        return distance;
    }

    public void move(int random) {
        if (random >= FORWARD_CONDITION) {
            distance += 1;
        }
    }
}
