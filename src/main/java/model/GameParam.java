package model;

public class GameParam {

    private final String[] carNames;

    private final int tryNum;


    private GameParam(String[] carNames, int tryNum) {
        this.carNames = carNames;
        this.tryNum = tryNum;
    }

    public static GameParam paramWithCarNamesAndTryNum(String[] carNames, int tryNum) {
        return new GameParam(carNames, tryNum);
    }

    public String[] getCarNames() {
        return carNames;
    }

    public int getTryNum() {
        return tryNum;
    }
}
