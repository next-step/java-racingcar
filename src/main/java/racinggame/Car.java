package racinggame;

public class Car {
    private int position;

    private Car() {
        this.position = 0;
    }

    public static Car create() {
        return new Car();
    }

    public int getPosition() {
        return position;
    }

    public void move(int number) {
        if (isMoveable(number)) {
            position++;
        }
    }

    private boolean isMoveable(int number) {
        return number >= 4;
    }
}
