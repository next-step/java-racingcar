package study.step3.dto;

public class RacingInput {
    public RacingInput(int carNum, int tryNum) {
        this.carNum = carNum;
        this.tryNum = tryNum;
    }

    private final int carNum;
    private final int tryNum;

    public int getCarNum() {
        return carNum;
    }
    public int getTryNum() {
        return tryNum;
    }
}
