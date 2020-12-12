package racing.domain;

public class RandomNumber {
    private static final double MIN_VALUE = 0;
    private static final double MAX_VALUE = 9;
    private static final int CAN_MOVE_NUMBER = 4;
    private int randomNum;

    public RandomNumber(int randomNum) {
        if(randomNum < MIN_VALUE || randomNum > MAX_VALUE) {
            throw new IllegalArgumentException("0과 9사이의 값이 아닙니다.");
        }
        this.randomNum = randomNum;
    }

    public boolean canMove() {
        return randomNum >= CAN_MOVE_NUMBER;
    }
}
