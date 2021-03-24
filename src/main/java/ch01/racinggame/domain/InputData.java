package ch01.racinggame.domain;

public class InputData {

    private int attemptCount = 0;
    private int carCount = 0;
    private String[] carNames;


    public InputData(String inputNameOfCars, int attemptCount) {
        this.attemptCount = attemptCount;
        this.carNames = inputNameOfCars.split(",");
        this.carCount = carNames.length;
    }

    public int carCount() {
        return carCount;
    }

    public int attemptCount() {
        return attemptCount;
    }

    public String[] carNames(){
        return this.carNames;
    }

}
