package model;

import java.util.List;

public class GameParam {

    private final List<CarName> carNames;

    private final int tryNum;


    private GameParam(List<CarName> carNames, int tryNum) {
        this.carNames = carNames;
        this.tryNum = tryNum;
    }

    public static GameParam paramWithCarNamesAndTryNum(List<CarName> carNames, int tryNum) {
        return new GameParam(carNames, tryNum);
    }

    public List<CarName> getCarNames() {
        return carNames;
    }

    public int getTryNum() {
        return tryNum;
    }
}
