package racing;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {

    private final RacingCars players;
    private final GameSpec gameSpec;
    private final RacingLap lap;

    public static RacingGame createGame(int playerCount, int trialCount) {
        return new RacingGame(
                RacingCars.createRacingCars(playerCount),
                GameSpec.createSimpleRacingCarSpec(),
                new RacingLap(trialCount)
        );
    }

    public List<RacingCars> start() {
        return IntStream.of(0, lap.getRemain())
                .mapToObj(idx -> race())
                .collect(Collectors.toList());
    }

    private RacingCars race() {
        final List<RacingCar> racingCars = players.getRacingCars()
                .stream()
                .map(player -> player.move(gameSpec.movableCount()))
                .collect(Collectors.toList());

        return new RacingCars(racingCars);
    }

    private RacingGame(final RacingCars players, final GameSpec gameSpec, final RacingLap lap) {
        this.players = players;
        this.gameSpec = gameSpec;
        this.lap = lap;
    }
}
