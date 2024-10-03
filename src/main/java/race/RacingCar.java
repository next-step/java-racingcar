package race;

public class RacingCar {

    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MOVE_CONDITION_NUMBER = 4;
    private int position = 0;
    private String name;
    private NumberPicker numberPicker;

    public RacingCar(String name, NumberPicker numberPicker) {
        validateNameLength(name);

        this.name = name;
        this.numberPicker = numberPicker;
    }

    public RacingCar(String name) {
        this(name, new NumberPicker());
    }

    public String getName() {
        return this.name;
    }

    public void moveForward() {
        if (isMovable(numberPicker.generateRandomNumberUnderTen())) {
            this.position++;
        }
    }

    public int getPosition() {
        return this.position;
    }

    public boolean hasSamePosition(int position) {
        return this.position == position;
    }

    private boolean isMovable(int number) {
        return number >= MOVE_CONDITION_NUMBER;
    }

    private void validateNameLength(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 빈 문자열일 수 없습니다.");
        }

        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }
}