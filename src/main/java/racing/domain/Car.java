package racing.domain;

public class Car{
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_CAR_MOVE = 4;
    private String name;
    private int moveCount;

    public Car(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이내로 입력하세요.");
        }
        this.moveCount = 0;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void move(int randomNum) {
        if (randomNum >= MIN_CAR_MOVE) {
            this.moveCount++;
        }
    }
}

