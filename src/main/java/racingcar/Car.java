package racingcar;

import static racingcar.OutputView.getPositionDisplay;

public class Car {

    public static final int MIN_MOVE_NUMBER = 0;
    public static final int MAX_MOVE_NUMBER = 9;
    public static final int MOVE_THRESHOLD = 4;
    public static final int MAX_NAME_LENGTH = 5;

    private int position;
    private String name;

    public Car() {
        this.position = 0;
    }

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String move(int number) {
        validateNumber(number);
        updatePosition(number);
        return getPositionDisplay(this);
    }

    private static void validateNumber(int number) {
        if (number < MIN_MOVE_NUMBER || number > MAX_MOVE_NUMBER) {
            throw new IllegalArgumentException("0부터 9까지의 숫자만 입력할 수 있습니다.");
        }
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 빈 문자열이나 null이 될 수 없습니다.");
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("각 자동차의 이름은 5자를 초과할 수 없습니다.");
        }
    }

    private void updatePosition(int number) {
        if (number >= MOVE_THRESHOLD) {
            position++;
        }
    }

    @Override
    public String toString() {
        return "Car{" + "position=" + position + ", name='" + name + '\'' + '}';
    }
}
