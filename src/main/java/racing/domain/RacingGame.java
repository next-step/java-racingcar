package racing.domain;

import racing.utils.RandomUtil;
import racing.view.ResultView;

public class RacingGame {
    private final Cars cars;
    private final int round;

    public RacingGame(Cars cars, int round) {
        this.cars = cars;
        this.round = round;
    }

    public void play() {
        for (int i = 0; i < round; i++) {
            cars.getCars().forEach(car -> car.move(RandomUtil.generateRandomNumber()));
            ResultView.printRaceResult(cars.getCars());
        }
    }

}
