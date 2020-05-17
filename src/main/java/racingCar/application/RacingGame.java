package racingCar.application;

import racingCar.domain.RacingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGame {
    private final int carCount;
    private final int time;
    private List<RacingCar> racingCarList;

    public RacingGame(int carCount, int time) {
        this.carCount = carCount;
        this.time = time;
        initRacingCars();
    }

    private void initRacingCars() {
        racingCarList = Stream.generate(RacingCar::new)
                            .limit(carCount)
                            .collect(Collectors.toList());
    }

    // TODO 구현
    public void move() {
        Random random = new Random();
        int randomNum = 0;

        for (int idx = 0; idx < carCount; idx++) {
            randomNum = random.nextInt(10);
            //MoveUtils.setPosition(racingCarList.get(idx), randomNum);
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
