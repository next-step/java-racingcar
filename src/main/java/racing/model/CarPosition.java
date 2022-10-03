package racing.model;

public class CarPosition {
    private int position;

    public CarPosition() {
        this.position = 1;
    }

    public CarPosition(int initPosition) {
        this.position = initPosition;
    }

    public int getPosition() {
        return position;
    }

    public void move(int speed) {
        this.position += speed;
    }
}
