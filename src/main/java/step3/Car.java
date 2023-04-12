package step3;

public class Car {
    private static final int MOVE_NUMBER = 4;
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private int location;

    public Car() {
        this.location = 0;
    }

    public void move(int input) {
        if (isMovable(input)) {
            this.location++;
        }
    }

    private boolean isMovable(int input) {
        if (input < MIN_NUMBER || input > MAX_NUMBER) {
            throw new RuntimeException("유효하지 않은 숫자입니다.");
        }
        return input >= MOVE_NUMBER;
    }

    public int location() {
        return location;
    }
}
