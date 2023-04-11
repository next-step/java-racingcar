package car;

public class Car {
    private static final int DEFAULT_MOVABLE_VALUE = 4;

    private int position;

    public Car(int position) {
        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }

    public void move(int randomNumber) {
        if(movable(randomNumber)) {
            position++;
        }
    }

    private boolean movable(int randomNumber) {
        return randomNumber > DEFAULT_MOVABLE_VALUE;
    }

}
