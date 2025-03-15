package step3;

public class Car {
    private static final int POSSIBLE_MOVE_CONDITION = 4;
    private static final int MAX_MOVE_CONDITION = 9;
    private static final int MIN_MOVE_CONDITION = 0;
    private int position = 0;

    public void move(int number) {
        if (number > MAX_MOVE_CONDITION || number < MIN_MOVE_CONDITION) {
            throw new IllegalArgumentException("움직일 수 있는 조건을 벗어났습니다. 값 : " + number);
        }
        if (number >= POSSIBLE_MOVE_CONDITION) {
            position++;
        }
    }

    public String getPosition() {
        return "-".repeat(position);
    }
}
