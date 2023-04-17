package step3;

public class GameStartParameter {

    private final int carNums;
    private final int runNums;

    public GameStartParameter(int carNums, int runNums) {
        this.carNums = carNums;
        this.runNums = runNums;
    }

    public int getCarNums() {
        return carNums;
    }

    public int getRunNums() {
        return runNums;
    }
}
