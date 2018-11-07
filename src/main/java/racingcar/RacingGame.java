package racingcar;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class RacingGame {

    private RacingGameOption racingGameOption;
    private RacingCarAccelerator racingCarAccelerator;

    public RacingGame(RacingGameOption racingGameOption) {
        this.racingGameOption = racingGameOption;
        initRacingCarAccelerator();
    }

    private void initRacingCarAccelerator() {
        this.racingCarAccelerator = new RacingCarAccelerator(4);
    }

    public List<RacingGameResultSet> startRace() {
        List<String> racingCarNames = racingGameOption.getRacingCarNames();
        int numberOfTimes = racingGameOption.getNumberOfTimes();

        List<RacingCar> racingCars = RacingCar.create(racingCarNames);

        List<RacingGameResultSet> resultSets = new ArrayList<>();
        for (int i = 0; i < numberOfTimes; i++) {
            List<RacingGameResultSet.RacingGameResult> roundResult = startRoundRace(racingCars);
            resultSets.add(RacingGameResultSet.of(roundResult));
        }
        return resultSets;
    }

    private List<RacingGameResultSet.RacingGameResult> startRoundRace(List<RacingCar> racingCars) {
        return racingCars.stream()
                .map(racingCar -> {
                    racingCar.move(racingCarAccelerator);
                    return RacingGameResultSet.RacingGameResult.of(racingCar);
                }).collect(toList());
    }
}