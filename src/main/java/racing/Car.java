package racing;

public class Car {
    private int position;

    public Car() {
    }

    public Car(int position) {
        this.position = position;
    }

    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }
}
