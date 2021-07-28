package racing;

public class Car {

    private static final int LOWER_BOUND = 4;
    private static final int UPPER_BOUND = 9;

    private Position position;

    public Car() {
        this(0);
    }

    public Car(int position) {
        this.position = new Position(position);
    }

    public void move(int number) {
        if (number >= LOWER_BOUND && number <= UPPER_BOUND) {
            this.position = position.add(1);
        }
    }

    public int getNowPosition() {
        return this.position.getPos();
    }
}
