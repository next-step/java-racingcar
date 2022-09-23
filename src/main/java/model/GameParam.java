package model;

public class GameParam {

    private final int carNum;

    private final int tryNum;

    public GameParam(int carNum, int tryNum) {
        this.carNum = carNum;
        this.tryNum = tryNum;
    }

    public int getCarNum() {
        return carNum;
    }

    public int getTryNum() {
        return tryNum;
    }
}