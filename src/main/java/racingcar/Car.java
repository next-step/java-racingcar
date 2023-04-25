package racingcar;

public class Car {

    private static final int FIVE = 5;
    private static final String CANNOT_ABOVE_FIVE_LETTERS = "자동차 이름은 5자를 초과할 수 없습니다.";
    private int moveCount = 0;
    private String carName;

    public Car(String carName) {
        this.carName = carName;
        isAboveFiveLetters();
    }

    public String getCarName() {
        return this.carName;
    }

    public int getMoveCount() {
        return moveCount;
    }

    private void isAboveFiveLetters() {
        if (carName.length() > FIVE) {
            throw new IllegalArgumentException(CANNOT_ABOVE_FIVE_LETTERS);
        }
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMove()) {
            moveCount++;
        }
    }
}