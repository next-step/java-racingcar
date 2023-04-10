package racing;

public class Car {

    private int position = 0;

    public Car() {
    }

    public Car(int initPosition) {
        this.position = initPosition;
    }

    public void move() {
        position++;
    }

    public int valueOfCurrentPosition() {
        return position;
    }
}
