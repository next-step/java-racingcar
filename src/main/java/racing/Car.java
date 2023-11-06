package racing;

public class Car {
    private int position = 0;

    public int getPosition() {
        return position;
    }

    public void move(int position) {
        this.position = position;
    }
}
