package racing;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {

    private final RacingGameSpec racingGameSpec;
    private final RacingCars racingCars;
    private final RacingLap racingLap;

    public static RacingGame init(int carCount, int trialCount) {
        return new RacingGame(
                RacingGameSpec.init(),
                RacingCars.init(carCount),
                RacingLap.init(trialCount)
        );
    }

    public List<RacingCars> start() {
        return IntStream.range(0, racingLap.getLap())
                .mapToObj(num -> race())
                .collect(Collectors.toList());
    }

    private RacingCars race() {
        final List<RacingCar> newRacingCars = racingCars.getRacingCars()
                .stream()
                .map(car -> car.move(racingGameSpec.moveCount()))
                .collect(Collectors.toList());

        return RacingCars.of(newRacingCars);
    }

    private RacingGame(RacingGameSpec racingGameSpec, RacingCars racingCars, RacingLap racingLap) {
        this.racingGameSpec = racingGameSpec;
        this.racingCars = racingCars;
        this.racingLap = racingLap;
    }
}
