package racing.car.car;

public class Car implements Movable {
    private int position;
    private static final int MOVE_THRESHOLD = 4;
    @Override
    public void move(int number) {
        if (isMoveAllowed(number)) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    private boolean isMoveAllowed(int number) {
        return number >= MOVE_THRESHOLD;
    }

}
