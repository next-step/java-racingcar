package racing.domain;

import racing.utils.RandomUtil;
import racing.view.ResultView;

import java.util.stream.IntStream;

public class RacingGame {
    private final Cars cars;
    private final int round;

    public RacingGame(Cars cars, int round) {
        this.cars = cars;
        this.round = round;
    }

    public void play() {

        IntStream.range(0, round)
                .forEach(i -> {
                    cars.getCars().forEach(car -> car.move(RandomUtil.generateRandomNumber()));
                    ResultView.printRaceResult(cars.getCars());
                });
    }

}
