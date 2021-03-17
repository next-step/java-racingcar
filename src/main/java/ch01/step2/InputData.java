package ch01.step2;

public class InputData {
    private int carCount = 0;
    private int attemptCount = 0;
    String[] progressArr;

    public InputData(int carCount, int attemptCount) {
        this.carCount = carCount;
        this.attemptCount = attemptCount;
        progressArr = new String[carCount];
    }

    public int getCarCount() {
        return carCount;
    }

    public int getAttemptCount() {
        return attemptCount;
    }

    public String[] getProgressArr() {
        return progressArr;
    }

    public void setProgressArr(String[] progressArr) {
        this.progressArr = progressArr;
    }
}
