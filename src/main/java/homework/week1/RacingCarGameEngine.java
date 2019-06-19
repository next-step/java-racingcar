package homework.week1;

import java.util.Random;

public class RacingCarGameEngine {

    private static final int MIN_RUN_CONDITION_VALUE = 4;

    private int numbersOfRacing;
    private int[] carPositions;

    public RacingCarGameEngine(int numbersOfRacing, int[] carPositions) {
        this.numbersOfRacing = numbersOfRacing;
        this.carPositions = carPositions;
    }

    public void validateUserInputValue(int value) throws IllegalArgumentException {
        if (value < 1)
            throw new IllegalArgumentException("반드시 1 이상의 숫자를 입력하세요!");
    }

    public int[] move() throws NullPointerException {
        if (carPositions == null) {
            throw new NullPointerException("경주에 참여하는 자동차 대수가 설정되지 않았습니다!");
        }

        Random randomNumber = new Random();
        for (int index=0; index < carPositions.length; index++) {
            carPositions[index] = getRunCount(checkRunCondition(randomNumber.nextInt(10)),
                    carPositions[index]);
        }
        return carPositions;
    }

    public int getNumbersOfRacing() {
        return this.numbersOfRacing;
    }

    public int[] getCarPositions() {
        return this.carPositions;
    }

    boolean checkRunCondition(int value) {
        if (value < MIN_RUN_CONDITION_VALUE) {
            return false;
        }
        return true;
    }

    int getRunCount(boolean isRun, int runCount) {
        if (isRun) {
            return ++runCount;
        }
        return runCount;
    }

}
