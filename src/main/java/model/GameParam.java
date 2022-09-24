package model;

public class GameParam {

    private final int carNum;

    private final int tryNum;


    private GameParam(int carNum, int tryNum) {
        this.carNum = carNum;
        this.tryNum = tryNum;
    }

    public static GameParam paramWithCarNumAndTryNum(int carNum, int tryNum) {
        return new GameParam(carNum, tryNum);
    }

    public int getCarNum() {
        return carNum;
    }

    public int getTryNum() {
        return tryNum;
    }
}
