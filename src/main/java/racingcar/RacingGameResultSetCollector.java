package racingcar;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class RacingGameResultSetCollector {

    private RacingCarAccelerator racingCarAccelerator;

    public RacingGameResultSetCollector(RacingCarAccelerator racingCarAccelerator) {
        this.racingCarAccelerator = racingCarAccelerator;
    }

    public List<RacingGameResultSet> collectRacingGameResultSets(List<RacingCar> racingCars, int numberOfTimes) {
        return IntStream.range(0, numberOfTimes)
                .mapToObj(i -> RacingGameResultSet.of(collectRacingGameResults(racingCars)))
                .collect(toList());
    }

    private List<RacingGameResultSet.RacingGameResult> collectRacingGameResults(List<RacingCar> racingCars) {
        return racingCars.stream()
                .map(racingCar -> {
                    racingCar.move(racingCarAccelerator);
                    return RacingGameResultSet.RacingGameResult.of(racingCar.getPosition());
                }).collect(toList());
    }
}
