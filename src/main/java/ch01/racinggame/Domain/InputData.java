package ch01.racinggame.Domain;

public class InputData {
    private int carCount = 0;
    private int attemptCount = 0;
    String[] progressArr;

    public InputData(int carCount, int attemptCount) {
        this.carCount = carCount;
        this.attemptCount = attemptCount;
        progressArr = new String[carCount];
    }

    public int carCount() {
        return carCount;
    }

    public int attemptCount() {
        return attemptCount;
    }

    public String[] progressArr() {
        return progressArr;
    }

}
