package racing;

public class Car {


    private int position;

    public void move() {
        this.position += 1;
    }

    public int getPosition() {
        return this.position;
    }
}
