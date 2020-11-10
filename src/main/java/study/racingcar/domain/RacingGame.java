package study.racingcar.domain;

import study.racingcar.domain.car.Car;
import study.racingcar.domain.car.CarSnapshot;
import study.racingcar.domain.car.CarSnapshotExporter;
import study.racingcar.domain.racingcars.RacingCars;
import study.racingcar.domain.racingcars.RacingCarsSnapshot;
import study.racingcar.domain.racingcars.RacingCarsSnapshotExporter;
import study.racingcar.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

/**
 * RacingGame을 진행하는 책임
 */
public class RacingGame {

    private GameConfiguration gameConfiguration;
    private RacingGameResult racingGameResult;
    public RacingGame(GameConfiguration gameConfiguration) {
        this.gameConfiguration = gameConfiguration;
    }

    public RacingGameResult startGame() {

        racingGameResult = new RacingGameResult();

        RacingCars racingCars = gameConfiguration.initRacingCars();

        racing(racingCars);

        award(racingCars);

        return racingGameResult;
    }

    private void racing(RacingCars racingCars) {

        for (int attempt = 0; gameConfiguration.doMoreAttempt(attempt); attempt++) {

            racingCars.nextAttempt();

            RacingCarsSnapshot racingCarsSnapshot = racingCars.export(new RacingCarsSnapshotExporter());

            racingGameResult.addGameProgressSnapshots(racingCarsSnapshot);

        }

    }

    private void award(RacingCars racingCars) {

        List<Car> winners = racingCars.whoIsFrontRunners();

        List<CarSnapshot> winnerSnapshots = winners.stream()
                .map(car -> car.export(new CarSnapshotExporter()))
                .collect(Collectors.toList());

        racingGameResult.addWinners(winnerSnapshots);
    }

}
