package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.RacingCarGame.createRacingCars;

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

    @DisplayName("최대 이동 거리 구하기")
    @ParameterizedTest
    @CsvSource({"CCCCC, 2"})
    void test_get_max_distance(String cars, int result) {
        racingCarGroups = new RacingCarGroups(createRacingCars(cars));
        racingCarGroups.move();
        racingCarGroups.move();
        assertThat(racingCarGroups.getMaxDistance()).isEqualTo(result);
    }

    @DisplayName("승자 찾기 - Q 랜덤으로 결과가 바뀌기 때문에 test 케이스 assert문을 어떻게 작성해야 할까요?")
    @ParameterizedTest
    @CsvSource({"CCCCC,1,CCCCC"})
    void test_get_find_winners(String cars, int condition, String result) {
        racingCarGroups = new RacingCarGroups(createRacingCars(cars));
        racingCarGroups.move();
        racingCarGroups.move();
        assertThat(racingCarGroups.findWinners(condition));
    }
}
