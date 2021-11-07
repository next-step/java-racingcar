package racinggame;

public class Car {

    private int position;

    public Car() {
        this.position = 0;
    }

    public void move(boolean movable) {
        if(movable) {
            position++;
        }
    }

    public int getPosition() {
        return this.position;
    }
}
