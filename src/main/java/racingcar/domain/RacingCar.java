package racingcar.domain;

import java.util.Objects;

/**
 * 경주용 자동차 클래스
 */
public class RacingCar {

    private AdvancedCount advancedCount = new AdvancedCount();  // 전진횟수
    private CarName carName;                                    // 자동차 이름

    public RacingCar() {
    }

    public RacingCar(CarName carName) {
        this.carName = carName;
    }
    public RacingCar(CarName carName, int count) {
        this.carName = carName;
        this.advancedCount = new AdvancedCount(count);
    }

    public int getAdvancedCount() {
        return advancedCount.getCount();
    }

    public String getCarName() {
        return carName.getName();
    }

    public void race(RandomNumber randomNumber) {
        if (randomNumber.isAdvancedCondition()) {
            advancedCount.add();
        }
    }

    public boolean isExistName() {
        return this.carName != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RacingCar racingCar = (RacingCar) o;

        if (!Objects.equals(advancedCount, racingCar.advancedCount))
            return false;
        return Objects.equals(carName, racingCar.carName);
    }

    @Override
    public int hashCode() {
        int result = advancedCount != null ? advancedCount.hashCode() : 0;
        result = 31 * result + (carName != null ? carName.hashCode() : 0);
        return result;
    }

}