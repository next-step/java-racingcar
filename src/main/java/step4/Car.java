package step4;

public class Car {
    private static final int NAME_LENGTH = 5;
    private static final int CONDITION = 4;

    private String name;
    private Position position;

    Car(final String name) {

        if (name.length() > NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다.");
        }

        this.name = name;
        this.position = new Position();
    }

    void moveOrStop(MoveRule rule) {
        if (rule.passCondition()) {
            position.move();
        }
    }

    void moveOrStop(int number) {
        if (number >= CONDITION) {
            position.move();
        }
    }

    String getName() {
        return name;
    }

    int getPosition() {
        return position.getPosition();
    }

}
