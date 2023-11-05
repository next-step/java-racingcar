package racingCar;

public class Racing {
    private int carCount;
    private int roundCount;

    public final int MINIMUN_CAR_COUNT = 2;
    public final int MINIMUM_ROUND_COUNT = 1;


    public Racing (int inputCarCount, int inputRoundCount) {
        carCount = inputCarCount;
        roundCount = inputRoundCount;
    }

    public boolean holdPossible() {
        if (carCount < MINIMUN_CAR_COUNT || roundCount < MINIMUM_ROUND_COUNT) {
            return false;
        }
        return true;
    }

}
