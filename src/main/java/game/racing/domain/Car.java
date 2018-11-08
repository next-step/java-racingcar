package game.racing.domain;

public class Car {

    public static final String DEFAULT_CAR_SHAPE = "-";

    private static final int MOVE_STANDARD = 4;
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    private int moveCount = 1;
    private String name;
    private String shape = DEFAULT_CAR_SHAPE;

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int moveCount) {
        this.name = name;
        this.moveCount = moveCount;
    }

    public Car(String name, String carShape) {
        this.name = name;
        this.shape = carShape;
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
        sb.append(this.getName()).append(" : ");
        for (int i = 0; i < this.getMoveCount(); i++) {
            sb.append(this.shape);
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

    public int maxMoveCount(int maxMoveCount) {
        return Math.max(this.moveCount, maxMoveCount);
    }

    public String getShape() {
        return this.shape;
    }
}
