package racingCar.Application;

import racingCar.Entity.RacingCar;
import racingCar.Utils.MoveUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private final int carCount;
    private final int time;
    private List<RacingCar> racingCarList;

    public RacingGame(int carCount, int time) {
        this.carCount = carCount;
        this.time = time;
    }

    // 자동차 Position 초기값 설정
    public void initRacingCars() {
        racingCarList = new ArrayList<>();
        for (int idx = 0; idx < carCount; idx++) {
            racingCarList.add(new RacingCar(1));
        }
    }

    // TODO 구현
    public void move() {
        Random random = new Random();
        int randomNum = 0;

        for (int idx = 0; idx < carCount; idx++) {
            randomNum = random.nextInt(10);
            MoveUtils.setPosition(racingCarList.get(idx), randomNum);
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
}
