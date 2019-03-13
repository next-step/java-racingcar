package racingcar.car;

import racingcar.util.RandomNumberGenerator;

public class PowerGenerator {

    private static final int MINIMUM_POWER = 4;
    private static final int GO = 1;
    private static final int STOP = 0;

    private RandomNumberGenerator randomNumberGenerator;

    //TODO: power Generator 는 getPower의 역할만 있어야 해
    public int determineMoveOrNot() {
        randomNumberGenerator = new RandomNumberGenerator();
        return getPower(randomNumberGenerator.getRandomNumberZeroToNine());
    }

    public int getPower(int power) {
        //19.03.10 - step1 피드백, random함수 기능 분리
        if (power >= MINIMUM_POWER) {
            return GO;
        }

        return STOP;
    }
}
