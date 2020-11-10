package racing.domain;

public class Car {
    private int position;

    public Car() {
        this.position = 0;
    }

    public void move(boolean isMove) {
        if (isMove) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
