package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;

public class RacingGame {

    private final Moveable moveable;

    public RacingGame(final Moveable moveable) {
        this.moveable = moveable;
    }

    public GameReport play(final int round, final int carCount) {
        List<RoundReport> roundReports = new ArrayList<>(round);
        Cars cars = createCars(carCount);
        for (int i = 0; i < round; i++) {
            cars = cars.forward(moveable);
            roundReports.add(cars.report());
        }
        return new GameReport(roundReports);
    }

    private Cars createCars(final int carCount) {
        return IntStream.range(0, carCount)
                .mapToObj(Car::of)
                .collect(collectingAndThen(Collectors.toList(), Cars::new));
    }
}
