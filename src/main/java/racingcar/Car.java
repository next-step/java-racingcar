package racingcar;

public class Car {
    private int position = 1;

    public void move(int random) {
        if (isMovable(random)) {
            this.position++;
        }
    }

    public int getPosition() {
        return this.position;
    }

    public boolean isMovable(int randomNumber) {
        return randomNumber >= 4;
    }
}
