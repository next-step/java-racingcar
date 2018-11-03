package racing;

public class Car {
    private int position;

    public Car() {
        this.position = 0;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }

    public void addPosition() {
        position++;
    }
}
