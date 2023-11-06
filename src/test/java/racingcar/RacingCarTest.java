package racingcar;


import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {
    @RepeatedTest(1000)
    void dice_테스트() {
        // given
        // when
        int actual = Dice.roll();
        // then
        assertThat(actual).isGreaterThanOrEqualTo(0).isLessThan(10);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 0", "2, 0", "3, 0", "4, 1", "5, 1", "6, 1", "7, 1", "8, 1", "9, 1"}, delimiter = ',')
    void move_테스트(int number, int expected) {
        // given
        RacingCar car = new RacingCar();
        // when
        car.action(number);
        // then
        assertThat(car.getCarPosition()).isEqualTo(expected);
    }
}