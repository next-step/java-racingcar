package racing.domain;

public class Car {
    public static final int MOVE_CHANGE_CONDITION = 4;
    public static final int VALIDATED_NAME_LENGTH = 5;
    private String name;
    private int moveCount;

    public Car(String name) {
        validateLength(name);
        this.name = name;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_CHANGE_CONDITION) {
            this.moveCount++;
        }
    }

    public boolean isWinner(int winnerCount) {
        return moveCount == winnerCount;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    private void validateLength(String name) {
        if (name.length() > VALIDATED_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이내로 입력하세요.");
        }
    }
}
