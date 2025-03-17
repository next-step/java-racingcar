package car;

public class Car {
    private int position = 0;

    public void move() {
        this.position++;
    }

    public int getPosition() {
        return this.position;
    }
}
