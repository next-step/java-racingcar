package step3;

public class Car {
    private static final int FORWARD = 4;
    private int position;

    public Car() {
        this.position = 0;
    }

    public void move(CarEngine carEngine) {
        if (carEngine.getPower() >= FORWARD) {
            position += 1;
        }
    }

    public int getPosition() {
        return this.position;
    }
}
