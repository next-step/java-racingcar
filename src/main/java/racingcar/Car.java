package racingcar;

public class Car {

    private static final String NOT_BLANK = "이름은 공백일 수 없습니다.";
    private static final String MAX_NAME_FORMAT = "이름은 %s자를 초과할수 없습니다.";
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MOVED_NUMBER = 4;

    private final RandomNumberGenerator randomNumberGenerator;
    private final String name;
    private int position = 0;

    public Car(final String name, final RandomNumberGenerator randomNumberGenerator) {
        validate(name);
        this.name = name;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    private void validate(final String name) {
        notBlank(name);
        maxLength(name);
    }

    private void notBlank(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(NOT_BLANK);
        }
    }

    private void maxLength(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format(MAX_NAME_FORMAT, MAX_NAME_LENGTH));
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
