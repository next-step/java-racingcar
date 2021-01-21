package racingcar;

import java.util.List;

public class Game {
    private int gameCnt = 0;
    private List<Car> carList;

    public Game(int cnt, List<Car> carList) {
        this.gameCnt = cnt;
        this.carList = carList;
    }
}
