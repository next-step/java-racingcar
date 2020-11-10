package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class TestRacingCar {
    RacingCar racingCar;

    @BeforeEach
    void setUp() {
        String cars = "BMW";
        racingCar = new RacingCar(cars);
    }

    @DisplayName("자동차 1번 이동")
    @ParameterizedTest
    @CsvSource({"1"})
    void test_move_one_step(int result) {
        racingCar.move(new GoStraightBehavior());
        assertThat(racingCar.getDistance())
                .isLessThanOrEqualTo(result);
    }

    @DisplayName("자동차 2번 이동")
    @ParameterizedTest
    @CsvSource({"2"})
    void test_move_two_step(int result) {
        racingCar.move(new GoStraightBehavior());
        racingCar.move(new GoStraightBehavior());
        assertThat(racingCar.getDistance())
                .isLessThanOrEqualTo(result);
    }

    @DisplayName("자동차 2번 이동: Q 테스트 문 작성에 어려움이 존재함")
    @ParameterizedTest
    @CsvSource({"2, BMW"})
    void test_is_winner(int condition, String result) {
        racingCar.move(new GoStraightBehavior());
        racingCar.move(new GoStraightBehavior());
        assertThat(racingCar.isWinner(new ArrayList<>(), condition));
    }
}
