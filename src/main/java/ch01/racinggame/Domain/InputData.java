package ch01.racinggame.Domain;

public class InputData {
    private String inputNameOfCars;
    private int attemptCount = 0;
    private int carCount = 0;
    private String[] carNames;


    public InputData(String inputNameOfCars, int attemptCount) {
        this.inputNameOfCars = inputNameOfCars;
        this.attemptCount = attemptCount;
        saveCarName();
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

    private void saveCarName(){
        this.carNames = this.inputNameOfCars.split(",");
    }
}
