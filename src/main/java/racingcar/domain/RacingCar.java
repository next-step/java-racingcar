package racingcar.domain;

public class RacingCar {

    private int position = 1;

    public int getPosition() {
        return this.position;
    }

    public void move() {
        this.position++;
    }

    public void move(boolean movable) {
        if (movable) {
            move();
        }
    }
}
