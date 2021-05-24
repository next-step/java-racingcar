package racing.domain;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private String name;
    private int moveCount;

    public Car(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이내로 입력하세요.");
        }
        this.moveCount = 0;
        this.name = name;
    }

    public void init() {
        this.moveCount = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    public void move(int randomNum) {
        if (randomNum >= 4) {
            this.moveCount++;
        }
    }
}
