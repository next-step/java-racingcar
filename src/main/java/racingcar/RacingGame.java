package racingcar;


import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private int TRY_CNT;
    private List<RacingCar> racingCars;

    public RacingGame(int CAR_CNT, int TRY_CNT) {
        racingCars = new ArrayList<>();
        for (int i = 0; i < CAR_CNT; i++) {
            racingCars.add(new RacingCar());
        }
        this.TRY_CNT = TRY_CNT;
    }

    public int getTRY_CNT() {
        return TRY_CNT;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}
