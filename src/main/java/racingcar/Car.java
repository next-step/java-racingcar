package racingcar;

public class Car {

    private static final int MOVE_THRESHOLD = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
        this.name = name;
    }

    public String name() {
        return name;
    }

    public int position() {
        return position;
    }

    public void moveIfPossible(int number) {
        if (number >= MOVE_THRESHOLD) {
            move();
        }
    }

    private void move() {
        position++;
    }
}
