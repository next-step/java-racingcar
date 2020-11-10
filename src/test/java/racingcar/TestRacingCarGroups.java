package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.RacingCarGameManager.createRacingCars;

public class TestRacingCarGroups {
    RacingCarGroups racingCarGroups;

    @DisplayName("자동차그룹 생성")
    @ParameterizedTest
    @CsvSource({"3, 3"})
    void test_create_racing_cars(int cars, int result) {
        racingCarGroups = new RacingCarGroups(createRacingCars(cars));
        racingCarGroups.move();
        assertThat(racingCarGroups.getRacingCars().size())
                .isEqualTo(result);
    }

    @DisplayName("자동차그룹 1번 이동")
    @ParameterizedTest
    @CsvSource({"3, 1"})
    void test_move(int cars, int result) {
        racingCarGroups = new RacingCarGroups(createRacingCars(cars));
        racingCarGroups.move();
        assertThat(racingCarGroups.getRacingCars().get(0).getDistance())
                .isLessThanOrEqualTo(result);
    }

    @DisplayName("자동차그룹 2번 이동")
    @ParameterizedTest
    @CsvSource({"3, 2"})
    void test_move_two_step(int cars, int result) {
        racingCarGroups = new RacingCarGroups(createRacingCars(cars));
        racingCarGroups.move();
        racingCarGroups.move();
        assertThat(racingCarGroups.getRacingCars().get(0).getDistance())
                .isLessThanOrEqualTo(result);
    }
}
