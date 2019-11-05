package racingCar;

public class Car {
    private static final int MOVE_CONDITION = 4;
    private Moveable moveableStrategy;

    private int position;

    public Car() {
        this.position = 0;
    }

    public Car(Moveable moveableStrategy) {
        this.moveableStrategy = moveableStrategy;
    }

    public boolean move() {

        if (moveableStrategy.move() >= MOVE_CONDITION) {
            this.position++;
            return true;
        }
        return false;
    }

    public int getPosition() {
        return position;
    }
}
