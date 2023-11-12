package car;

public class Car {

    private static final int MAX_CAR_NAME_LENGTH = 5;

    private int position;
    private final String name;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        validateCarNameLength(name);

        this.name = name;
        this.position = position;
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            this.position++;
        }
    }

    public String carName() {
        return this.name;
    }

    public int currentPosition() {
        return this.position;
    }

    public boolean isSameMax(int max) {
        return this.position == max;
    }

    public int compareMaxPosition(int max) {
        return Math.max(this.position, max);
    }

    private void validateCarNameLength(String name) {
        if (isNameEmpty(name) || name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 1 ~ 5 까지 입력 가능합니다.");
        }
    }

    private boolean isNameEmpty(String name) {
        return name == null || name.isBlank();
    }
}
