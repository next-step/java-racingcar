package racingcar.car;

import racingcar.util.RandomNumberGenerator;

public class PowerGenerator {

    private RandomNumberGenerator randomNumberGenerator;

    //TODO: power Generator 는 getPower의 역할만 있어야 해
    //TODO: 어떻게 하면 더 분리할 수 있을지 모르겠다.
//    public void determineMoveOrNot(int[] carPositions) {
    public int determineMoveOrNot() {
        randomNumberGenerator = new RandomNumberGenerator();
        return getPower(randomNumberGenerator.getRandomNumberZeroToNine());
    }

    public int getPower(int power) {
        //19.03.10 - step1 피드백, random함수 기능 분리
        if (power >= 4) return 1;

        return 0;
    }
}
