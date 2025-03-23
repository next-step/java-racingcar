package step5.domain;

public class Car {
    private static final int INITIAL_POSITION = 1;
    private static final int CONDITION = 4;
    private static final int NAME_LENGTH = 5;
    private String name;
    private int position;

    public Car(String name) {
        this(name, INITIAL_POSITION);
    }

    public Car(String name, int position) {
        validateNameLength(name);
        this.name = name;
        this.position = position;
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_LENGTH) {
            throw new RuntimeException("자동차의 이름은 5글자를 초과할 수 없습니다.");
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void move(int randomNum) {
        if (randomNum >= CONDITION) {
            this.position++;
        }
    }
}
