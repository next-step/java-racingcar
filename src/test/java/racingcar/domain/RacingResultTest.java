package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RacingResultTest {
    private static final int ATTEMPT_NUMBER = 5;
    private static final CarMover RANDOM_NUMBER_CAR_MOVER = new RandomNumberMover();

    private RacingCars racingCars;

    @BeforeEach
    void setUp() {
        List<RacingCar> racingCarList = new ArrayList<>();

        RacingCar racingCar1 = RacingCar.of("DD");
        racingCar1.race(ATTEMPT_NUMBER, RANDOM_NUMBER_CAR_MOVER);
        racingCarList.add(racingCar1);

        RacingCar racingCar2 = RacingCar.of("LALA");
        racingCar2.race(ATTEMPT_NUMBER, RANDOM_NUMBER_CAR_MOVER);
        racingCarList.add(racingCar2);

        RacingCar racingCar3 = RacingCar.of("MOMO");
        racingCar3.race(ATTEMPT_NUMBER, RANDOM_NUMBER_CAR_MOVER);
        racingCarList.add(racingCar3);

        racingCars = new RacingCars(racingCarList);
    }

    @DisplayName("aggregate 메소드 테스트")
    @Test
    void aggregate_test() {
        RacingResult racingResult = RacingResult.aggregate(ATTEMPT_NUMBER, racingCars);

        assertThat(racingResult).isNotNull();
        assertThat(racingResult.getAttempt()).isEqualTo(ATTEMPT_NUMBER);
        assertThat(racingResult.getResultByAttempt(ATTEMPT_NUMBER - 1)).hasSize(3);
        assertThat(racingResult.getWinner(ATTEMPT_NUMBER - 1)).isNotBlank();
    }

    @DisplayName("getResultByAttempt 메소드 테스트")
    @Test
    void getResultByAttempt_test() {
        int testAttempt = 1;

        RacingResult racingResult = RacingResult.aggregate(ATTEMPT_NUMBER, racingCars);
        assertThat(racingResult.getResultByAttempt(testAttempt)).hasSize(3);
    }

    @DisplayName("getWinner 메소드 테스트")
    @ParameterizedTest
    @MethodSource("provideCarNames")
    void getWinner_test(Stream<String> names, boolean result) {
        RacingResult racingResult = RacingResult.aggregate(ATTEMPT_NUMBER, racingCars);

        assertThat(racingResult.getWinner(ATTEMPT_NUMBER - 1)).isNotBlank();

        assertThat(names.anyMatch(name -> racingResult
                .getWinner(ATTEMPT_NUMBER - 1)
                .contains(name))).isEqualTo(result);

    }

    private static Stream<Arguments> provideCarNames() {
        return Stream.of(
                Arguments.of(Stream.of("DD", "LALA", "MOMO"), true),
                Arguments.of(Stream.of("TOTO"), false)
        );
    }
}
