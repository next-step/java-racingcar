package step3;

public class Car {

    private int position;

    public Car() {
        this.position = 0;
    }

    public Car(int position) {
        this.position = position;
    }

    public void move(int distance) {
        this.position += distance;
    }

    public int getPosition() {
        return this.position;
    }
}
