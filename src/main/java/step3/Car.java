package step3;

public class Car {
    private int position;

    public Car() {
        this.position = 0;
    }

    public void move(Moving moving) {
        if (moving.canMove()) {
            position++;
        }
    }

    int getPosition() {
        return position;
    }
}
