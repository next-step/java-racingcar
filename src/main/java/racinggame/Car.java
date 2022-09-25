package racinggame;

public class Car {

    private int position;

    public Car() {
        this.position = 0;
    }

    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }

}
