package ch01.step2;

public class InputData {
    int carCount = 0;
    int attemptCount = 0;
    String[] progressArr;
    InputData(int carCount,int attemptCount){
        this.carCount = carCount;
        this.attemptCount = attemptCount;
        progressArr = new String[carCount];
    }
    public int getCarCount() {
        return carCount;
    }

    public void setCarCount(int carCount) {
        this.carCount = carCount;
    }

    public int getAttemptCount() {
        return attemptCount;
    }

    public void setAttemptCount(int attemptCount) {
        this.attemptCount = attemptCount;
    }

    public String[] getProgressArr() {
        return progressArr;
    }

    public void setProgressArr(String[] progressArr) {
        this.progressArr = progressArr;
    }
}
