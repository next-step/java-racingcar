package study;

public class Car {
    private int position;

    public void move(boolean movable) {
        if (movable) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
