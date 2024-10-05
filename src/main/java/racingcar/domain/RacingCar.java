package racingcar.domain;

public class RacingCar {

    private int position;
    private final String name;

    public RacingCar(String name) {
        this(name, 1);
    }

    public RacingCar(String name, int position) {
        this.position = position;
        if (name.length() > 5) {
            throw new IllegalStateException("자동차의 이름은 5자리를 초과할 수 없습니다.");
        }
        this.name = name;
    }

    public int getMaxPosition(int maxPosition) {
        return Math.max(position, maxPosition);
    }

    public boolean isSamePosition(int position) {
        return position == this.position;
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

    public String getName() {
        return this.name;
    }
}
