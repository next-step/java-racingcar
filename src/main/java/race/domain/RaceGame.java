package race.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RaceGame {
    private final Cars cars;
    private final int numberIterations;

    public static RaceGame fromEngineFactoryAndCarNamesAndIterations(EngineFactory factory, List<String> carNames, int numberIterations) {
        Cars cars = new Cars(factory, carNames);
        return new RaceGame(cars, numberIterations);
    }

    private RaceGame(Cars cars, int numberIterations) {
        this.cars = cars;
        this.numberIterations = numberIterations;
    }

    public List<LapScores> play() {
        return IntStream.range(0, numberIterations)
                .mapToObj(i -> cars.lap())
                .collect(Collectors.toUnmodifiableList());
    }
}
