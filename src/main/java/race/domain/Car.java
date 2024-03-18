package race.domain;

import java.util.Objects;

public class Car {

    private final int CONDITION_OF_MOVE = 4;
    private final static int MAX_LENGTH_OF_NAME = 5;
    private final Position position;
    private final String name;

    private Car(String name) {
        this(name, Position.createInstance(0));
    }

    private Car(String name, Position position) {
        validateName(name);
        this.name = name;
        this.position = position;
    }

    public static Car createInstance(String name) {
        return new Car(name);
    }

    public void move(int number) {
        if (!canMove(number)) {
            return;
        }
        position.increase();
    }

    private boolean canMove(int number) {
        return number >= CONDITION_OF_MOVE;
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public boolean isEqualPosition(int number) {
        return this.position.equals(Position.createInstance(number));
    }

    public boolean isEqualPosition(Position position) {
        return this.position.equals(position);
    }

    private void validateName(String name) {
        int lengthOfName = name.length();
        if (lengthOfName > MAX_LENGTH_OF_NAME) {
            throw new IllegalArgumentException(
                    String.format("이름을 5자를 초과 할수 없습니다. 해당 이름은 %s 는 %d ", name, lengthOfName));
        }
    }

    public int max(int max) {
        return this.position.max(max);
    }
}
