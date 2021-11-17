package racingcar;

public class Car {
    private final static int STEP = 1;

    private int movement;

    public Car() {
        this.movement = 0;
    }

    public Car(int movement) {
        this.movement = movement;
    }

    public int getMovement() {
        return this.movement;
    }

    public void move(MovingStrategy strategy) {
        if(strategy.canMove()) {
            increaseMovement();
        }
    }

    private void increaseMovement() {
        this.movement = this.movement + STEP;
    }
}
