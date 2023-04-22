package race.step3.model;

public class InputData {
    private int numCar;
    private int numTry;

    public InputData(int numCar, int numTry) {
        this.numCar = validatePositiveNum(numCar);
        this.numTry = validatePositiveNum(numTry);
    }

    public int validatePositiveNum(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("0 이거나 음수는 허용되지 않습니다.");
        }
        return value;
    }

    public int getNumCar() {
        return numCar;
    }

    public int getNumTry() {
        return numTry;
    }
}
