package carrace;

public class Car {
    private int position;

    public Car() {
        this.position = 0;
    }

    Car(int position) {
        this.position = position;
    }

    public void move(boolean movable) {
        if (movable) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
