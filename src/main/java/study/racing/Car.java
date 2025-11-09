package study.racing;

public class Car {
    private int position;

    public Car() {
        this.position = 0;
    }

    public void move(int randonValue) {
        if (randonValue >= 4) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
