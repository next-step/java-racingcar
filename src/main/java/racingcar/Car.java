package racingcar;

public class Car {
    private int position;

    public Car() {
        this.position = 1;
    }

    public void move(int randomNum) {
        if (randomNum >= 4) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
