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
    private ResultView resultView;

    public RacingGame(GameConfiguration gameConfiguration, ResultView resultView) {
        this.gameConfiguration = gameConfiguration;
        this.resultView = resultView;
    }

    public void startGame() {

        RacingCars racingCars = gameConfiguration.initRacingCars();

        racing(racingCars);

        award(racingCars);

    }

    private void racing(RacingCars racingCars) {

        for (int attempt = 0; gameConfiguration.doMoreAttempt(attempt); attempt++) {

            racingCars.nextAttempt();

            RacingCarsSnapshot racingCarsSnapshot = racingCars.export(new RacingCarsSnapshotExporter());

            resultView.displayCurrentStatus(racingCarsSnapshot);

        }

    }

    private void award(RacingCars racingCars) {

        List<Car> winners = racingCars.whoIsFrontRunners();

        List<CarSnapshot> winnerSnapshots = winners.stream()
                .map(car -> car.export(new CarSnapshotExporter()))
                .collect(Collectors.toList());

        resultView.displayWinner(winnerSnapshots);
    }

}
