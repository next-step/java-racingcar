package step3.domain;

public class Car {
    private int position = 0;

    public int getPosition() {
        return position;
    }

    public void move() {
        this.position++;
    }
}
