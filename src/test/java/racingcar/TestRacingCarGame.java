package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.RacingCarGame;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.RacingCarGameManager.createRacingCars;

public class TestRacingCarGame {
    RacingCarGame racingCarGame;

    @DisplayName("입력받은 자동차 수")
    @ParameterizedTest
    @CsvSource({"1,2", "2,3", "3,4"})
    void test_check_total_cars(int cars, int rounds) {
        racingCarGame = new RacingCarGame(new RacingCarGroups(createRacingCars(cars)), rounds);
        assertThat(racingCarGame.getRacingCarGroups()).isInstanceOf(RacingCarGroups.class);
    }

    @DisplayName("입력받은 시도 횟수")
    @ParameterizedTest
    @CsvSource({"1,2,2", "2,3,3", "3,4,4"})
    void test_check_total_rounds(int cars, int rounds, int resultRounds) {
        racingCarGame = new RacingCarGame(new RacingCarGroups(createRacingCars(cars)), rounds);
        assertThat(racingCarGame.getRounds()).isEqualTo(resultRounds);
    }

    @DisplayName("생성된 자동차 개수")
    @ParameterizedTest
    @CsvSource({"3,2,3"})
    void test_check_creation_of_racing_cars(int cars, int rounds, int result) {
        racingCarGame = new RacingCarGame(new RacingCarGroups(createRacingCars(cars)), rounds);
        assertThat(racingCarGame.getRacingCarGroups().getRacingCars().size())
                .isEqualTo(result);
    }

    @DisplayName("자동차 게임 실행 결과")
    @ParameterizedTest
    @CsvSource({"1,2,0", "3,5,1" })
    void test_run_game(int cars, int rounds, int index) {
        racingCarGame = new RacingCarGame(new RacingCarGroups(createRacingCars(cars)), rounds);
        racingCarGame.runGame();
        assertThat(racingCarGame.getRacingCarGroups().getRacingCars().get(index).getDistance())
                .isLessThanOrEqualTo(rounds);
    }
}
