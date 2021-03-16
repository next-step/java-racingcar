package racingcar.domain;

public class Car {
    private static final int NAME_MAX_LENGTH = 5;
    public static final int INITIAL_POSITION = 1;

    private int position = INITIAL_POSITION;
    private String name;

    public Car(String name) {
        verifyNameLength(name);
        this.name = name;
    }

    public void moveOrStay(int value) {
        if (MovingForwardCondition.isSatisfied(value)) {
            move();
        }
    }

    private void verifyNameLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("자동차 이름은 %d자를 초과할 수 없습니다.", NAME_MAX_LENGTH));
        }
    }

    private void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
