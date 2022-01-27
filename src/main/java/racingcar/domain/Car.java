package racingcar.domain;

public class Car {

    private String name;
    private int position;
    private Engine engine;
    private static final int NAME_LIMIT_LENGTH = 5;
    private static final String NAME_VALIDATION_MESSAGE = "[ERROR] 이름은 5 글자 이하입니다.";

    public Car(String name, Engine engine) {
        validateName(name);
        this.name = name;
        this.position = 0;
        this.engine = engine;
    }

    public String getName() {
        return name;
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty() || name.length() > NAME_LIMIT_LENGTH) {
            throw new IllegalArgumentException(NAME_VALIDATION_MESSAGE);
        }
    }

    public void move() {
        if (engine.movable()) {
            position += 1;
        }
    }

    public int position() {
        return position;
    }
}
