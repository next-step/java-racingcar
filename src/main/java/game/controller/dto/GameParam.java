package game.controller.dto;

import java.util.List;

public class GameParam {

    private final List<String> carNames;

    private final int countOfRound;

    public GameParam(List<String> carNames, int tryNum) {
        this.carNames = carNames;
        this.countOfRound = tryNum;
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getCountOfRound() {
        return countOfRound;
    }
}
