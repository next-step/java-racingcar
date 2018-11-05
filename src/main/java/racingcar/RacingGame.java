package racingcar;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class RacingGame {

    private RacingGameOption racingGameOption;
    private RacingCarAccelerator accelerator;

    public RacingGame(RacingGameOption racingGameOption) {
        initRacingGameOption(racingGameOption);
        initAccelerator(racingGameOption);
    }

    private void initRacingGameOption(RacingGameOption racingGameOption) {
        this.racingGameOption = racingGameOption;
    }

    private void initAccelerator(RacingGameOption racingGameOption) {
        int maxSpeed = racingGameOption.getNumberOfTimes() + 1;
        this.accelerator = new RacingCarAccelerator(maxSpeed);
    }

    public List<RacingGameResultSet> start() {

        int numberOfCar = racingGameOption.getNumberOfCar();
        int numberOfTimes = racingGameOption.getNumberOfTimes();

        List<RacingCar> racingCars = RacingCar.create(numberOfCar);

        return IntStream.range(0, numberOfTimes)
                .mapToObj(i -> RacingGameResultSet.of(collectRacingGameResult(racingCars)))
                .collect(toList());
    }

    private List<RacingGameResultSet.RacingGameResult> collectRacingGameResult(List<RacingCar> racingCars) {
        return racingCars.stream()
                .map(racingCar -> {
                    racingCar.move(accelerator);
                    return RacingGameResultSet.RacingGameResult.of(racingCar.getPosition());
                }).collect(toList());
    }
}