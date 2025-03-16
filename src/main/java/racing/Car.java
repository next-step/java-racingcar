package racing;

public class Car {

    private static final String POSITION_SYMBOL = "-";
    private static final int MOVE_THRESHOLD = 4;
    private int position;
    private CarName name;

    public Car(String name) {
        this.position = 0;
        this.name = new CarName(name);

    }

    public void race() {
        if (movable()) {
            move();
        }
    }

    private void move() {
        position++;
    }

    private boolean movable() {
        return movable(RandomNumberFactory.createRandomNumber());
    }

    public boolean movable(int number) {
        return number >= MOVE_THRESHOLD;
    }

    public String getPositionString() {
        return POSITION_SYMBOL.repeat(position);
    }

    public CarName getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isWinner(int maxPosition) {
        return position == maxPosition;
    }
}
