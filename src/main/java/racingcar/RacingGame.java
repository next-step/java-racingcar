package racingcar;


import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private int tryCnt;
    private List<RacingCar> racingCars;

    public RacingGame(int carCnt, int tryCnt) {
        racingCars = new ArrayList<>();
        for (int i = 0; i < carCnt; i++) {
            racingCars.add(new RacingCar());
        }
        this.tryCnt = tryCnt;
    }

    public int getTryCnt() {
        return tryCnt;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}
