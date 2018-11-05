package racing_game;

public class Car {

    private static final int MOVE_STANDARD = 4;
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    private int moveCount = 1;
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public void move(int moveNumber) {
        if(isMove(moveNumber)) {
            moveCount++;
        }
    }

    private boolean isMove(int number) {
        if(number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("숫자는 0 ~ 9 범위여야 합니다.");
        }

        return number >= MOVE_STANDARD;
    }

    public int getMoveCount() {
        return this.moveCount;
    }

    public String getName() {
        return name;
    }
}
