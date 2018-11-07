package racingcar;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class RacingGameResultSetCollector {

    private RacingCarAccelerator racingCarAccelerator;

    public RacingGameResultSetCollector(RacingCarAccelerator racingCarAccelerator) {
        this.racingCarAccelerator = racingCarAccelerator;
    }

    public List<RacingGameResultSet> collectRacingGameResultSets(List<RacingCar> racingCars, int numberOfTimes) {
        List<RacingGameResultSet> resultSets = new ArrayList<>();
        for (int i = 0; i < numberOfTimes; i++) {
            List<RacingGameResultSet.RacingGameResult> racingGameResults = collectRacingGameResults(racingCars);
            resultSets.add(RacingGameResultSet.of(racingGameResults));
        }
        return resultSets;
    }

    private List<RacingGameResultSet.RacingGameResult> collectRacingGameResults(List<RacingCar> racingCars) {
        return racingCars.stream()
                .map(racingCar -> {
                    racingCar.move(racingCarAccelerator);
                    return RacingGameResultSet.RacingGameResult.of(racingCar);
                }).collect(toList());
    }
}
