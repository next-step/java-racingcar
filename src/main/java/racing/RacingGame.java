package racing;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {

    private final RacingCars cars;
    private final GameSpec gameSpec;
    private final RacingLap lap;

    private RacingGame(final RacingCars cars, final GameSpec gameSpec, final RacingLap lap) {
        this.cars = cars;
        this.gameSpec = gameSpec;
        this.lap = lap;
    }

    public static RacingGame createGame(int playerCount, int trialCount) {
        return new RacingGame(
                RacingCars.createRacingCars(playerCount),
                GameSpec.createSimpleRacingCarSpec(),
                new RacingLap(trialCount)
        );
    }

    public List<RacingCars> start() {
        return IntStream.range(0, lap.getRemain())
                .mapToObj(idx -> race())
                .collect(Collectors.toList());
    }

    private RacingCars race() {
        return cars.getRacingCars()
                .stream()
                .map(player -> player.move(gameSpec.movableCount()))
                .collect(Collectors.collectingAndThen(Collectors.toList(), RacingCars::new));
    }

}
