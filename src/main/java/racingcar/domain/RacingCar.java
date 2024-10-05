package racingcar.domain;

public class RacingCar {

    private int position = 1;
    private final String name;

    public RacingCar(String name) {
        if (name.length() > 5) {
            throw new IllegalStateException("자동차의 이름은 5자리를 초과할 수 없습니다.");
        }
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
