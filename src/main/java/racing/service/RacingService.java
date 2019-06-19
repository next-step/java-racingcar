package racing.service;

import racing.domain.EntireCars;
import racing.dto.*;
import racing.generator.RandomValueGenerator;
import racing.generator.ValueGenerator;

import java.util.stream.IntStream;

public class RacingService {

    public static final int RANDOM_NUMBER_BOUND = 10;
    private static final int START_RACE_COUNT = 1;

    private final RacingInfo racingInfo;
    private final ValueGenerator valueGenerator;

    public RacingService(RacingInfo racingInfo) {

        this(racingInfo, new RandomValueGenerator(RANDOM_NUMBER_BOUND));
    }

    public RacingService(RacingInfo racingInfo, ValueGenerator valueGenerator) {

        this.racingInfo = racingInfo;
        this.valueGenerator = valueGenerator;
    }

    public RacingResult run() {

        EntireCars entireCars = EntireCars.of(racingInfo.getCarNames());

        return race(entireCars);
    }

    private RacingResult race(EntireCars entireCars) {

        RacingResult racingResult = RacingResult.initRacingScore(RacingScore.of(entireCars));

        IntStream.range(START_RACE_COUNT, racingInfo.getAttempts())
                .forEach(currentRaceCount -> {
                    entireCars.race(valueGenerator);
                    racingResult.addCurrentRacingScore(RacingScore.of(entireCars));
                });

        return racingResult;
    }

}
