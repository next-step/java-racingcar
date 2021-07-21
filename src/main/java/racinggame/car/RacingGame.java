package racinggame.car;

import racinggame.ui.ResultView;
import racinggame.util.RandomNumber;

public class RacingGame {

    private final Cars cars;
    private final Count num;
    private final RandomNumber randomNumber;

    private RacingGame(Cars cars, Count num) {
        this.cars = cars;
        this.num = num;
        this.randomNumber = new RandomNumber();
    }

    public static RacingGame of(int carNumber, int countNumber) {
        return new RacingGame(Cars.manyOf(Count.of(carNumber)), Count.of(countNumber));
    }

    public ResultView play() {
        int count = this.num.getCount();
        for (int i = 0; i < count; i++) {
            cars.race(randomNumber);
        }

        return new ResultView(cars, count);
    }
}
