package step4;

import java.util.Random;

public class Car {
    private static final int NAME_LENGTH = 5;

    private String name;
    private Position position;

    public Car(String name) {

        if (name.length() > NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다.");
        }

        this.name = name;
        this.position = new Position();
    }

    public void moveOrStop(MoveRule rule) {
        if (rule.passCondition()) {
            position.move();
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position.getPosition();
    }

}
