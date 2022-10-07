package racing.service;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.MovableStrategy;
import racing.ui.ResultView;

public class RacingGameService {

    private static final int FIRST_INDEX = 0;

    public Cars prepare(String[] carNames) {
        return new Cars(
            IntStream.range(FIRST_INDEX, carNames.length)
                .mapToObj(index -> new Car(carNames[index], FIRST_INDEX))
                .collect(Collectors.toList()));
    }

    public void racing(Cars cars, int tryCount, ResultView resultView,
        MovableStrategy movableStrategy) {
        resultView.start();

        IntStream.range(FIRST_INDEX, tryCount)
            .forEach(index -> {
                cars.move(movableStrategy);
                cars.print(resultView);
            });

        resultView.winner(cars.findWinners());
    }

}
