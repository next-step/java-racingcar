package racingcar.domain;

public class RacingCar {

    private int position = 1;
    private final String name;

    public RacingCar(String name) {
        this.name = name;
    }

    public int getPosition() {
        return this.position;
    }

    public void move(boolean movable) {
        if (movable) {
            move();
        }
    }

    public void move() {
        this.position++;
    }
}
