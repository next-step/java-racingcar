package racingcar.domain;

public class Car {
    private static final int NAME_MAX_LENGTH = 5;
    private String name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        if (isNameLength(name)) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
        this.name = name;
        this.position = position;
    }

    private boolean isNameLength(String name) {
        return name.length() > NAME_MAX_LENGTH;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.moveAble()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public int selectMaxPosition(int maxPosition) {
        if (this.getPosition() > maxPosition) {
            maxPosition = this.getPosition();
        }
        return maxPosition;
    }

    public boolean isCarAtMaxPosition(int maxPosition) {
        return maxPosition == this.getPosition();
    }
}
