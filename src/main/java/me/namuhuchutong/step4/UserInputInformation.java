package me.namuhuchutong.step4;

public class UserInputInformation {

    private final CarNames carNames;
    private final int times;

    public UserInputInformation(CarNames carNames, int times) {
        validateRacingTimes(times);
        this.carNames = carNames;
        this.times = times;
    }

    public static void validateRacingTimes(int times) {
        if (times <= 0) {
            throw new IllegalArgumentException("경주 수는 음수이거나 0일 수 없습니다. - " + times);
        }
    }

    public int getTimes() {
        return times;
    }

    public int getNumberOfCars() {
        return this.carNames.getNumberOfNames();
    }

    public CarNames getCarNames() {
        return carNames;
    }
}
