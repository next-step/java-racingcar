package racingcar.application;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingGame;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingService {
    private static final int GAME_DIFFICULTY = 4;

    public List<ResultView> race(final InputView view) {
        final RacingGame racingGame = new RacingGame(GAME_DIFFICULTY);
        final List<RacingCar> racingCars = racingGame.makeRacingCars(view.getNumberOfCars());
        return IntStream.rangeClosed(1, view.getTime())
                .mapToObj(time -> race(racingGame, racingCars, time))
                .collect(Collectors.toList())
                ;
    }

    private ResultView race(final RacingGame racingGame, final List<RacingCar> racingCars, final int time) {
        racingGame.race(racingCars);
        return new ResultView(time, bindViews(racingCars));
    }

    private RacingCarViews bindViews(final List<RacingCar> racingCars) {
        return new RacingCarViews(
                racingCars.stream()
                        .map(racingCar -> new RacingCarView(racingCar.getId(), racingCar.getPosition()))
                        .collect(Collectors.toList())
        );
    }
}
