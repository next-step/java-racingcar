package step3;

public class Car {
    private int position;

    public Car() {
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public void go() {
        this.position++;
    }

}
