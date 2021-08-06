package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import race.domain.Car;
import race.domain.Cars;
import race.domain.Condition;
import race.domain.Name;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarsTest {

    private static final int DEFAULT_TRY_COUNT = 5;
    private static final int DEFAULT_CAR_COUNT = 3;
    private static final String[] DEFAULT_CAR_NAMES = {"pobi", "crong", "honux"};

    @DisplayName("생성된 Car객체에 각 시도 횟수(라운드)만큼 이동(전진,후진)이 있는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void playUntilEnd(int index) {
        Cars cars = getCars();
        cars.playUntilEnd();

        Car car = cars.findCarsInfo().get(index);
        int distanceCount = car.getDistance().size();
        assertThat(distanceCount).isEqualTo(DEFAULT_TRY_COUNT);
    }

    @DisplayName("자동차 게임 우승자 있는지 확인. 최소 1명이 나와야한다.")
    @Test
    void findWinners() {
        Cars cars = getCars();
        cars.playUntilEnd();

        String winners = cars.findWinners().stream()
                .map(Name::toString)
                .collect(Collectors.joining(","));
        assertThat(winners.split(",").length).isGreaterThanOrEqualTo(1);
    }


    private Cars getCars() {
        return new Cars(new Condition(DEFAULT_CAR_COUNT, DEFAULT_TRY_COUNT, Arrays.asList(DEFAULT_CAR_NAMES)));
    }

}