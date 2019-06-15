package racinggame;

public class Car {
    private int position = 1;

    public void move() {
        this.position += 1;
    }

    public int getPosition() {
        return position;
    }
}
