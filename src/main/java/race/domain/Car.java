package race.domain;

public class Car {

    private int position;

    public Car() {
        this.position = 0;
    }

    public void move(int number) {
        if (4 <= number) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
