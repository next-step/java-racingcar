package racingcar;

import java.util.Objects;
import java.util.Random;

/**
 * 경주용 자동차 클래스
 */
public class RacingCar {

    private final int moveCount;    // 이동횟수
    private int advancedCount;      // 전진횟수
    private CarName carName;        // 자동차 이름

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
     * 자동차 경주
     * @return 경주 결과를 담고 있는 경주용 자동차
     */
    public RacingCar race() {
        Random random = new Random();
        for (int i = 0; i < moveCount; i++) {
            int randomNumber = random.nextInt(10);
            checkAdvancedCondition(randomNumber);
        }
        return this;
    }

    /**
     * 자동차 경주 (테스트용)
     * @param randomNumbers 랜덤숫자 배열
     * @return 경주 결과를 담고 있는 경주용 자동차
     */
    public RacingCar race(int[] randomNumbers) {
        for (int randomNumber : randomNumbers) {
            checkAdvancedCondition(randomNumber);
        }
        return this;
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

    /**
     * 자동차 이름 존재 여부
     * @return 존재하면 true, 존재하지 않으면 null
     */
    public boolean isExistName() {
        return this.carName != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RacingCar racingCar = (RacingCar) o;

        if (moveCount != racingCar.moveCount) return false;
        if (advancedCount != racingCar.advancedCount) return false;
        return Objects.equals(carName, racingCar.carName);
    }

    @Override
    public int hashCode() {
        int result = moveCount;
        result = 31 * result + advancedCount;
        result = 31 * result + (carName != null ? carName.hashCode() : 0);
        return result;
    }

}