package racing_game;

public class Car {

    private static final String CAR_SHAPE = "-";
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

    public String getCurrentState() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" : ");
        for (int i = 0; i < this.getMoveCount(); i++) {
            sb.append(CAR_SHAPE);
        }
        return sb.toString();
    }

    public boolean isSameMoveCount(int moveCount) {
        return this.getMoveCount() == moveCount;
    }

    public int getMoveCount() {
        return this.moveCount;
    }

    public String getName() {
        return name;
    }
}
