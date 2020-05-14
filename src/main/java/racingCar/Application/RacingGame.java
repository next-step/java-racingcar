package racingCar.Application;

import racingCar.Entity.RacingCar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final int carCount;
    private final int time;
    private List<RacingCar> racingCarList;

    public RacingGame(int carCount, int time) {
        this.carCount = carCount;
        this.time = time;
    }

    public void initRacingCars() {
        racingCarList = new ArrayList<>();
        for (int idx = 0; idx < carCount; idx++) {
            racingCarList.add(new RacingCar(0));
        }
    }

    public int getTime() {
        return time;
    }

    public int getCarCount() {
        return carCount;
    }

    public List<RacingCar> getRacingCarList() {
        return racingCarList;
    }

    //    public int[] move() {
//        // TODO 구현
//    }
}
