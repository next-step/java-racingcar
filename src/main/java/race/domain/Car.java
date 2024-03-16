package race.domain;

public class Car {

    private static final int FORWARD_STANDARD = 4;
    private static final int MOVE = 1;
    private String name;
    private int position = 0;

    public Car() {
    }

    public Car(int position) {
        this.position = position;
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public boolean canForward(int random) {
        return random >= FORWARD_STANDARD;
    }

    public void move() {
        this.position += MOVE;
    }

    public int getMax(Car car, int max) {
        return Math.max(max, car.getPosition());
    }

    public boolean isSamePosition(Car car, int max) {
        return max == car.getPosition();
    }

    public void makeForward(int random) {
        if (canForward(random)) {
            move();
        }
    }
}
