package racingcar.domain.car;

import racingcar.domain.util.RandomNumberGenerator;

public class PowerGenerator {

    private static final int MINIMUM_POWER = 4;
    private static final int GO = 1;
    private static final int STOP = 0;

    //TODO: power Generator 는 getPower의 역할만 있어야 해
    //매번 Random객체를 만들고 있었다... 비효율적. 공용인데.
    public int determineMoveOrNot() {
        return getPower(RandomNumberGenerator.getRandomNumberZeroToNine());
    }

    public int getPower(int power) {
        //19.03.10 - step1 피드백, random함수 기능 분리
        if (power >= MINIMUM_POWER) {
            return GO;
        }

        return STOP;
    }
}
