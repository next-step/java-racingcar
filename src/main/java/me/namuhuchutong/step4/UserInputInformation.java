package me.namuhuchutong.step4;

public class UserInputInformation {

    private final int times;
    private final int numberOfCars;

    public UserInputInformation(int times, int numberOfCars) {
        validateRacingTimes(times);
        this.times = times;
        this.numberOfCars = numberOfCars;
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
        return numberOfCars;
    }
}
