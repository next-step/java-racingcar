package racing;

public class Car {
    private int position = 0;

    public Car() {
    }

    public void move(CarMovement carMovement) {
        if (carMovement.isMove()) {
            this.position++;
        }
    }

    public int currentPosition() {
        return this.position;
    }
}
