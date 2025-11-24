package racingGame;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다: " + name);
        }
    }

    public void move(MoveStrategy strategy) {
        if (strategy.isMove()) {
            position++;
        }
    }

    public int position() {
        return position;
    }

    public String name() {
        return name;
    }
}
