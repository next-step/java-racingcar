package racingcar.domain;

public class Car {
    private static final int START_POSITION = 0;
    private static final int MAX_NAME_LENGTH = 5;

    private int position;
    private String name;

    public Car(String name) {
        validate(name);
        this.name = name;
        this.position = START_POSITION;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(boolean moveAble) {
        if(moveAble) {
            position++;
        }
    }

    public void validate(String name) {
        validateNameLength(name);
        isBlank(name);
        isNull(name);
    }
    public void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다.");
        }
    }

    public void isBlank(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("공백은 입력할 수 없습니다.");
        }
    }

    public void isNull(String name) {
        if (name == null) {
            throw new NullPointerException("Null 값은 입력할 수 없습니다.");
        }
    }
}
