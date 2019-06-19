package step3.domain;

public class Car {
    private final static int INITIAL_POSITION = 0;
    private final static int DISTANCE_PER_MOVE = 1;
    private final static int MOVE_CRITERION = 4;

    private int position;
    private String carName;

    public Car(String carName) {
        this.position = INITIAL_POSITION;
        this.carName = carName;
    }

    public void move(int randomNumber) {
        if (canMove(randomNumber)) {
            position += DISTANCE_PER_MOVE;
        }
    }

    private boolean canMove(int randomNumber) {
        return randomNumber >= MOVE_CRITERION;
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName;
    }

}
