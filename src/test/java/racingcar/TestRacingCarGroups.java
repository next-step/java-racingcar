package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.RacingCarGameManager.createRacingCars;

public class TestRacingCarGroups {
    RacingCarGroups racingCarGroups;

    @DisplayName("자동차그룹 생성")
    @ParameterizedTest
    @CsvSource({"AAA, 1"})
    void test_create_racing_cars(String cars, int result) {
        racingCarGroups = new RacingCarGroups(createRacingCars(cars));
        racingCarGroups.move();
        assertThat(racingCarGroups.getRacingCars().size())
                .isEqualTo(result);
    }

    @DisplayName("자동차그룹 1번 이동")
    @ParameterizedTest
    @CsvSource({"BBBB, 1"})
    void test_move(String cars, int result) {
        racingCarGroups = new RacingCarGroups(createRacingCars(cars));
        racingCarGroups.move();
        assertThat(racingCarGroups.getRacingCars().get(0).getDistance())
                .isLessThanOrEqualTo(result);
    }

    @DisplayName("자동차그룹 2번 이동")
    @ParameterizedTest
    @CsvSource({"CCCCC, 2"})
    void test_move_two_step(String cars, int result) {
        racingCarGroups = new RacingCarGroups(createRacingCars(cars));
        racingCarGroups.move();
        racingCarGroups.move();
        assertThat(racingCarGroups.getRacingCars().get(0).getDistance())
                .isLessThanOrEqualTo(result);
    }
}
