package study.step3.dto;

public class Input {
    public Input(int carNum, int tryNum) {
        this.carNum = carNum;
        this.tryNum = tryNum;
    }

    private int carNum;
    private int tryNum;

    public int getCarNum() {
        return carNum;
    }
    public int getTryNum() {
        return tryNum;
    }
}
