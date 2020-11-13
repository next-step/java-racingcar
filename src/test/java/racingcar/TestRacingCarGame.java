package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class TestRacingCarGame {
    RacingCarGame racingCarGame;

    @DisplayName("입력받은 자동차 수")
    @ParameterizedTest
    @CsvSource(value = {"AAA,BBBB,CCCCC:2", }, delimiter = ':')
    void test_check_total_cars(String cars, int rounds) {
        racingCarGame = new RacingCarGame(cars, rounds);
        assertThat(racingCarGame.getRacingCarGroups()).isInstanceOf(RacingCarGroups.class);
    }

    @DisplayName("입력받은 시도 횟수")
    @ParameterizedTest
    @CsvSource(value = {"AAA,BBBB,CCCCC:2:2", "AAA,BBBB,CCCCC:3:3", "AAA,BBBB,CCCCC:4:4"}, delimiter = ':')
    void test_check_total_rounds(String cars, int rounds, int resultRounds) {
        racingCarGame = new RacingCarGame(cars, rounds);
        assertThat(racingCarGame.getRounds()).isEqualTo(resultRounds);
    }

    @DisplayName("생성된 자동차 개수")
    @ParameterizedTest
    @CsvSource(value = {"AAA:1:1", "AAA,BBBB:2:2", "AAA,BBBB,CCCCC:3:3"}, delimiter = ':')
    void test_check_creation_of_racing_cars(String cars, int rounds, int result) {
        racingCarGame = new RacingCarGame(cars, rounds);
        assertThat(racingCarGame.getRacingCarGroups().getRacingCars().size())
                .isEqualTo(result);
    }

    @DisplayName("자동차 게임 실행 결과")
    @ParameterizedTest
    @CsvSource(value = {"AAA,BBBB,CCCCC:2:0", "AAA,BBBB,CCCCC:5:0" },delimiter = ':')
    void test_run_game(String cars, int rounds, int index) {
        racingCarGame = new RacingCarGame(cars, rounds);
        racingCarGame.runGame();
        assertThat(racingCarGame.getRacingCarGroups().getRacingCars().get(index).getDistance())
                .isLessThanOrEqualTo(rounds);
    }

    @DisplayName("자동차 게임 우승자 결과")
    @ParameterizedTest
    @CsvSource({"BBBB,2,BBBB", "CCCCC,5,CCCCC" })
    void test_run_game_winner(String cars, int rounds, String winner) {
        racingCarGame = new RacingCarGame(cars, rounds);
        racingCarGame.runGame();
        assertThat(racingCarGame.getWinners().get(0)).isEqualTo(winner);
    }
}
