package racingcar;

import java.util.Random;

/**
 * 경주용 자동차 클래스
 */
public class RacingCar {

    private final int moveCount;    // 이동횟수
    private int advancedCount;      // 전진횟수
    private CarName carName;

    // 전진 조건 숫자
    private final static int ADVANCED_CONDITION_NUMBER = 4;

    public RacingCar(int moveCount) {
        this.moveCount = moveCount;
    }

    public RacingCar(int moveCount, CarName carName) {
        this.moveCount = moveCount;
        this.carName = carName;
    }

    public int getAdvancedCount() {
        return advancedCount;
    }

    public CarName getCarName() {
        return carName;
    }

    /**
     * 경주 시작
     */
    public void race() {
        Random random = new Random();
        for (int i = 0; i < moveCount; i++) {
            int randomNumber = random.nextInt(10);
            checkAdvancedCondition(randomNumber);
        }
    }

    /**
     * 전진 조건 체크 (랜덤 숫자가 4이상일 경우 전진)
     * @param randomNumber 램덤 숫자
     */
    public void checkAdvancedCondition(int randomNumber) {
        if (randomNumber >= ADVANCED_CONDITION_NUMBER) {
            advancedCount++;
        }
    }

}