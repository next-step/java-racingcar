package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class RacingResultTest {
    private static final int ATTEMPT_NUMBER = 5;

    private List<RacingVehicle> racingCars;

    @BeforeEach
    void setUp() {
        racingCars = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            RacingCar racingCar = new RacingCar();
            racingCar.setCarMover(new RandomNumberMover());
            racingCar.race(ATTEMPT_NUMBER);

            racingCars.add(racingCar);
        }
    }

    @DisplayName("aggregate 메소드 테스트")
    @Test
    void aggregate_test() {
        RacingResult racingResult = RacingResult.aggregate(ATTEMPT_NUMBER, racingCars);

        assertThat(racingResult).isNotNull();
        assertThat(racingResult.getAttempt()).isEqualTo(ATTEMPT_NUMBER);
    }

    @DisplayName("getResultByAttempt 메소드 테스트")
    @Test
    void getResultByAttempt_test() {
        int testAttempt = 1;

        List<Integer> isExpectedResultByAttempt = racingCars.stream()
                .map(RacingVehicle::getRaceRecord)
                .map(raceRecord -> raceRecord.getBy(testAttempt))
                .collect(Collectors.toList());

        RacingResult racingResult = RacingResult.aggregate(ATTEMPT_NUMBER, racingCars);
        assertThat(racingResult.getResultByAttempt(testAttempt)).hasSameSizeAs(isExpectedResultByAttempt);
        assertThat(racingResult.getResultByAttempt(testAttempt).get(0)).isEqualTo(isExpectedResultByAttempt.get(0));
    }
}