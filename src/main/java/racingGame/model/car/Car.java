package racingGame.model.car;

public class Car {

    private static final int MIN_POSITION_VALUE = 0;
    private static final String MIN_POSITION_ERROR_MESSAGE = "위치는 최소 0 이상 입력 해주세요!";
    private static final int MAX_NAME_VALUE = 5;
    private static final String MAX_NAME_ERROR_MESSAGE = "이름은 5자를 초과할수 없습니다!";

    private int position;
    private String name;

    public Car() {
        this(0, "");
    }

    public Car(int position, String name) {
        validatePosition(position);
        validateName(name);
        this.position = position;
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_VALUE) {
            throw new IllegalArgumentException(MAX_NAME_ERROR_MESSAGE);
        }
    }

    private void validatePosition(int position) {
        if (position < MIN_POSITION_VALUE) {
            throw new IllegalArgumentException(MIN_POSITION_ERROR_MESSAGE);
        }
    }

    public Car clone() {
        return new Car(this.position, this.name);
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    public void move() {
        this.position++;
    }

    public int getGreaterPosition(int position) {
        if (position < this.position) {
            return this.position;
        }
        return position;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }
}
