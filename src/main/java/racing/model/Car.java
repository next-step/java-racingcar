package racing.model;

public class Car {
    private int position;

    public Car() {
        this.position = 0;
    }

    public void move(int number) {
        if (number >= 4) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
