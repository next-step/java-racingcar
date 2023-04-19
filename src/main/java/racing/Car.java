package racing;

public class Car {
    private final int NAME_MAX_LENGTH = 5;

    private final String name;
    private int moveStatus;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public void move(int moveCount) {
        moveStatus += moveCount;
    }

    public String getName() {
        return name;
    }

    public int getMoveStatus() {
        return moveStatus;
    }
}
