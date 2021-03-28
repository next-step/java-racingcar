package racingcar.domains;

public class RacingCar {

    public static final int MIN_MOVE_CONDITION = 4;

    private int moveCnt;

    public int move(int randomNum) {
        if (randomNum >= MIN_MOVE_CONDITION) {
            return moveCnt++;
        }
        return moveCnt;
    }

    public int getMoveCnt() {
        return moveCnt;
    }
}
