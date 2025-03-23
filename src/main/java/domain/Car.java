package domain;

import utils.NumberGenerator;

public class Car {
    private final static int BASE_NUMBER = 4;
    private final static int MAX_NAME_LENGTH = 5;
    private final String name;
    private final Position position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        validateName(name);
        this.name = name;
        this.position = new Position(position);
    }

    public void move(NumberGenerator numberGenerator) {
        int movableNumber = numberGenerator.generate();
        if (isAtLeastBaseNumber(movableNumber)) {
            goForward();
        }
    }

    private void goForward() {
        this.position.increase();
    }

    public int getPosition() {
        return this.position.getValue();
    }

    public String getName() {
        return this.name;
    }

    private boolean isAtLeastBaseNumber(int number) {
        return BASE_NUMBER <= number;
    }

    private void validateName(String name) {
        if (exceedsMaxNameLength(name)) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    private boolean exceedsMaxNameLength(String name) {
        return name.length() > MAX_NAME_LENGTH;
    }
}
