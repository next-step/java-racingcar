package step3;

public class Car {

    private int position;
    private final int CAR_MOVE_CRITERIA = 4;

    public Car() {
        this.position = 0;
    }

    public boolean isOver(int randomValue) {
        return CAR_MOVE_CRITERIA <= randomValue;
    }

    public void move(int randomValue) {
        if (isOver(randomValue)) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
