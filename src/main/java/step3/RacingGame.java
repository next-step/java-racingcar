package step3;

import java.util.List;

public class RacingGame {
    int carCount, tryCount;
    Cars cars;

    public RacingGame(int carCount, int tryCount) {
        this.carCount = carCount;
        this.tryCount = tryCount;
        cars = Cars.of(carCount);
    }

    public List race(Dice dice, List<Integer> racingResult) {
        for (int i = 0; i < tryCount; i++) {
            cars.moveCars(dice);
            cars.addCarsScore(racingResult);
        }
        return racingResult;
    }


}
