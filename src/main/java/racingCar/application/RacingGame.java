package racingCar.application;

import racingCar.domain.RacingCar;

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

        for (int idx = 0; idx < carCount; idx++) {
            int randomNum = random.nextInt(10);
            racingCarList.get(idx).move(randomNum);
        }
    }

    public int getTime() {
        return time;
    }

    public List<RacingCar> getRacingCarList() {
        return racingCarList;
    }
}
