package step3;

public class Car {
    private static final int FORWARD = 4;
    private Position position;

    public Car() {
        this.position = new Position();
    }

    public void move(CarEngine carEngine) {
        if (carEngine.getPower() >= FORWARD) {
            position.add();
        }
    }

    public int getPosition() {
        return position.getPosition();
    }
}
