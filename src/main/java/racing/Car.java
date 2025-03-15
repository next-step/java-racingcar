package racing;

public class Car {
    private int position = 1;

    public Car() {
    }

    public Car(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        position++;
    }
}
