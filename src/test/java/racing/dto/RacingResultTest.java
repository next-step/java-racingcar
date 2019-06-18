package racing.dto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racing.domain.Car;
import racing.domain.EntireCars;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RacingResultTest {

    private int moveValue = 5;

    @ParameterizedTest(name = "우승자이름 계산. carNames={0}, raceCondition={3}, winnersNames={2}")
    @MethodSource
    void getWinnersName(List<String> carNames, Predicate<Car> raceCondition, String winnersNames, String raceConditionDescription) {

        EntireCars entireCars = EntireCars.of(carNames);
        entireCars.getCars().stream().filter(raceCondition).forEach(car -> car.race(moveValue));
        RacingScore racingScore = RacingScore.of(entireCars);
        RacingResult racingResult = RacingResult.initRacingScore(racingScore);

        assertThat(racingResult.getWinnersName()).isEqualTo(winnersNames);
    }

    private static Stream<Arguments> getWinnersName() {

        return Stream.of(
                Arguments.of(Arrays.asList("pobi", "crong", "honux"), (Predicate<Car>) Objects::nonNull, "pobi, crong, honux", "전체"),
                Arguments.of(Arrays.asList("pobi", "crong", "honux"), (Predicate<Car>) car -> "pobi".equals(car.getName()) || "crong".equals(car.getName()), "pobi, crong", "pobi/crong"),
                Arguments.of(Arrays.asList("pobi", "crong", "honux"), (Predicate<Car>) car -> "pobi".equals(car.getName()), "pobi", "pobi")
        );
    }
}