package study.CarRacing;

public class Car {
    private int position;

    public Car() {
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public void move(boolean canMove) {
        if (canMove) {
            position++;
        }
    }
}
