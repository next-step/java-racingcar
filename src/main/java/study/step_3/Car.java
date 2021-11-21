package study.step_3;

public class Car {
    private int position;

    public void position(boolean movable) {
        if (movable) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
