package me.namuhuchutong.step4;

public class UserInputInformation {

    private final CarNames carNames;
    private final int times;

    public UserInputInformation(CarNames carNames, int times) {
        this.carNames = carNames;
        this.times = times;
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
