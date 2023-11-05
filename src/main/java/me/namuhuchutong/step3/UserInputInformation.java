package me.namuhuchutong.step3;

public class UserInputInformation {

    private final int numberOfCars;

    private final int times;

    public UserInputInformation(int numberOfCars, int times) {
        validateTimes(times);
        this.numberOfCars = numberOfCars;
        this.times = times;
    }

    private void validateTimes(int times) {
        if (times <= 0) {
            throw new IllegalArgumentException("자동차 경주 횟수는 음수이거나 0일 수 없습니다 - " + times);
        }
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getTimes() {
        return times;
    }
}
