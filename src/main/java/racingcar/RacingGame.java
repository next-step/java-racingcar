package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGame {

    private final List<Car> lacingCars;
    private final RacingData racingData;

    public RacingGame() {

        racingData = InputView.input();

        lacingCars = Stream.iterate(0, i -> i + 1)
                .limit(racingData.getNumberOfCars())
                .map(i -> new Car())
                .collect(Collectors.toList());
    }

    public void start() {

        ResultView.printStart();

        for (int i = 0; i < racingData.getNumberOfCars(); i++) {
            moveCars(i);
            ResultView.printResult(lacingCars.get(i));
            ResultView.lineFeed();
        }
    }

    public void moveCars(int i) {
        lacingCars.get(i).moveAndStop();
    }
}
