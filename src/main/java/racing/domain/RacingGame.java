package racing.domain;

import racing.utils.RandomUtil;
import racing.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

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
            ResultView.printRaceResult(cars);
        }
    }

    public Winners findWinner() {
        final int max = cars.getMaxPosition();
        List<Car> winners = cars.getCars().stream()
                .filter(car -> car.isMatch(max))
                .collect(Collectors.toList());
        return new Winners(winners);
    }
}
