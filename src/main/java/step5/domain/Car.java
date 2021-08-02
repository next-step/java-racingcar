package step5.domain;

public class Car {
    private static int position;

    public Car(int position) {
        this.position = position;
    }

    public void moveForward() {
        position++;
    }

    public int getCurrentPosition() {
        return position;
    }
}
