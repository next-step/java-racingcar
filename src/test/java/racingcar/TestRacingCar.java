package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class TestRacingCar {
    RacingCar racingCar;

    @DisplayName("자동차 1번 이동")
    @ParameterizedTest
    @CsvSource({"1"})
    void test_move_one_step(int result) {
        racingCar = new RacingCar("BMW", 1);
        racingCar.move(new GoStraightBehavior());
        assertThat(racingCar.getDistance())
                .isLessThanOrEqualTo(result);
    }

    @DisplayName("자동차 2번 이동")
    @ParameterizedTest
    @CsvSource({"2"})
    void test_move_two_step(int result) {
        racingCar = new RacingCar("BMW", 1);
        racingCar.move(new GoStraightBehavior());
        racingCar.move(new GoStraightBehavior());
        assertThat(racingCar.getDistance())
                .isLessThanOrEqualTo(result);
    }

    @DisplayName("우승 자동차")
    @ParameterizedTest
    @CsvSource({"2, BMW"})
    void test_is_winner(int condition, String result) {
        racingCar = new RacingCar("BMW", 2);
        assertThat(racingCar.isWinner(new ArrayList<>(), condition))
                .containsExactly(result);
    }
}
