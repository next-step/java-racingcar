package racingcar;

import java.util.List;

public class RacingGame {

    private RacingGameOption racingGameOption;
    private RacingCarAccelerator racingCarAccelerator;
    private RacingGameResultSetCollector racingGameResultSetCollector;

    public RacingGame(RacingGameOption racingGameOption) {
        this.racingGameOption = racingGameOption;

        initRacingCarAccelerator();
        initRacingGameResultSetCollector();
    }

    private void initRacingCarAccelerator() {
        this.racingCarAccelerator = new RacingCarAccelerator(4);
    }

    private void initRacingGameResultSetCollector() {
        this.racingGameResultSetCollector = new RacingGameResultSetCollector(racingCarAccelerator);
    }

    public List<RacingGameResultSet> start() {
        List<String> racingCarNames = racingGameOption.getRacingCarNames();
        int numberOfTimes = racingGameOption.getNumberOfTimes();

        List<RacingCar> racingCars = RacingCar.create(racingCarNames);

        return racingGameResultSetCollector.collectRacingGameResultSets(racingCars, numberOfTimes);
    }
}