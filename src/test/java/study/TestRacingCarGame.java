package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class TestRacingCarGame {
    RacingCarGame racingCarGame;

    @DisplayName("입력받은 자동차 수")
    @ParameterizedTest
    @CsvSource({"1,2,1", "2,3,2", "3,4,3"})
    void test_get_cars(int cars, int rounds, int resultCars) {
        racingCarGame = new RacingCarGame(cars, rounds);
        assertThat(racingCarGame.getCars()).isEqualTo(resultCars);
    }

    @DisplayName("입력받은 시도 횟수")
    @ParameterizedTest
    @CsvSource({"1,2,2", "2,3,3", "3,4,4"})
    void test_get_rounds(int cars, int rounds, int resultRounds) {
        racingCarGame = new RacingCarGame(cars, rounds);
        assertThat(racingCarGame.getRounds()).isEqualTo(resultRounds);
    }

    @DisplayName("생성된 자동차")
    @ParameterizedTest
    @CsvSource({"1,2,0"})
    void test_get_racing_car_by_index(int cars, int rounds, int index) {
        racingCarGame = new RacingCarGame(cars, rounds);
        assertThat(racingCarGame.getRacingCarByIndex(index))
                .isInstanceOf(RacingCar.class);
    }

    @DisplayName("자동차 게임 실행 - Q: assert를 어떻게 해야하지?")
    @ParameterizedTest
    @CsvSource({"1,2", "3,5" })
    void test_run(int cars, int rounds) {
        racingCarGame = new RacingCarGame(cars, rounds);
        racingCarGame.run();
        //TODO : 이런케이스에서는 어떻게 assert문을 생성해야 할지 모르겠다.
    }

}
