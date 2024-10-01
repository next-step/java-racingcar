package race;

public class RacingCar {

    private int position = 0;
    private String name;
    private static final int MOVE_CONDITION_NUMBER = 4;
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

    public boolean checkSamePosition(int position) {
        return this.position == position;
    }

    private boolean isMovable(int number) {
        return number >= MOVE_CONDITION_NUMBER;
    }

    private void validateNameLength(String name) {
        if (name.length() == 0) {
            throw new IllegalArgumentException("자동차 이름은 빈 문자열일 수 없습니다.");
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }
}