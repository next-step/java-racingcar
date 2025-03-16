package racing;

public class Car {

    private static final String POSITION_SYMBOL = "-";
    private int position;

    public Car() {
        this.position = 0;
    }

    public void race() {
        if (movable()) {
            move();
        }
    }

    public void move() {
        position++;
    }

    private boolean movable() {
        return movable(RandomNumberFactory.createRandomNumber());
    }

    public boolean movable(int number) {
        return number >= 4;
    }

    public String getPositionString() {
        return POSITION_SYMBOL.repeat(position);
    }
}
