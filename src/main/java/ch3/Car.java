package ch3;

public class Car {

    private int position = 0;
    private String name;

    public int getPosition() {
        return position;
    }

    public String name() {
        return name;
    }

    public void move(int number) {
        if (isMovingCondition(number)) {
            this.position++;
        }
    }

    private boolean isMovingCondition(int number) {
        final int MOVE_CONDITION_NUMBER = 4;
        return number >= MOVE_CONDITION_NUMBER;
    }

    public void makeName(String name) {
        if (isNameMaxLength(name)) {
            throw new RuntimeException("이름은 5자를 초과할 수 없습니다");
        }
        this.name = name;
    }

    private boolean isNameMaxLength(String name) {
        final int MAX_NAME_LENGTH = 5;
        return name.length() > MAX_NAME_LENGTH;
    }
}
