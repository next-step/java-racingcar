package racing;

public class Car {
    private int position;

    public Car() {
        this.position = 0;
    }

    public boolean move(int input) {
        if (input < 4) {
            return false;
        }

        position++;
        return true;
    }

    public int position() {
        return position;
    }
}
