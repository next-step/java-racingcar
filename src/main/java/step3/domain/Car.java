package step3.domain;

public class Car {

    public static final int RAN_NUMBER_VALID_LOWER = 0;
    public static final int RAN_NUMBER_VALID_UPPER = 9;
    private static final int MOVE_CONDITION = 4;
    private int moveDistance = 0;

    public void move(int randomNum) {
        if(ranNumberRangeCheck(randomNum))
            throw new IllegalArgumentException();

        if(MOVE_CONDITION <= randomNum)
            moveDistance++;
    }

    public boolean ranNumberRangeCheck(int randomNum) {
        return randomNum < RAN_NUMBER_VALID_LOWER || randomNum > RAN_NUMBER_VALID_UPPER;
    }

    public int getPosition() {
        return moveDistance;
    }
}
