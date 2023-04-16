package racingcar;

public class Car {

    private static final String NOT_BLANK = "이름은 공백일 수 없습니다.";
    private static final String MAX_LENGTH = "이름은 5를 초과할수 없습니다.";
    private static final int MOVED_NUMBER = 4;

    private final RandomNumberGenerator randomNumberGenerator;
    private final String name;
    private int position = 0;

    public Car(String name, RandomNumberGenerator randomNumberGenerator) {
        validate(name);
        this.name = name;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    private void validate(String name) {
        notBlank(name);
        maxLength(name);
    }

    private void notBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(NOT_BLANK);
        }
    }

    private void maxLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(MAX_LENGTH);
        }
    }

    public void racing() {
        if (isMove()) {
            position++;
        }
    }

    private boolean isMove() {
        return randomNumberGenerator.generate() >= MOVED_NUMBER;
    }

    public int getPosition() {
        return position;
    }
}
