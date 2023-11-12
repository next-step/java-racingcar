package racingcar;


import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.RacingCar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.CarNameValidator.carNameValidation;
import static racingcar.WinnerFinder.findWinner;

class RacingCarTest {
    @RepeatedTest(1000)
    void dice_테스트() {
        // given
        // when
        int actual = Dice.roll();
        // then
        assertThat(actual).isNotNegative().isLessThan(10);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 0", "2, 0", "3, 0", "4, 1", "5, 1", "6, 1", "7, 1", "8, 1", "9, 1"}, delimiter = ',')
    void move_테스트(int number, int expected) {
        // given
        RacingCar car = new RacingCar("dummy");
        // when
        car.action(number);
        // then
        assertThat(car.getCarPosition()).isEqualTo(expected);
    }

    @Test
    void car_이름_validation() {
        // given
        String originCarNames = "123               ,          1234,  12345  ";
        // then
        assertThat(carNameValidation(originCarNames))
                .isEqualTo(Arrays.asList("123", "1234", "12345"));
    }

    @Test
    void car_이름_5자_초과() {
        // given
        String originCarNames = "123456, 1234, 12345";
        // then
        assertThatThrownBy(() -> carNameValidation(originCarNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자 이하만 가능합니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"a,10;b,10;c,5|a, b", "a,100;b,10;c,5|a", "a,10;b,10;c,10|a, b, c"}, delimiter = '|' )
    void 우승자_추출_combined(String input, String expected) {
        // given
        String [] carInfos = input.split(";");

        List<RacingCar> racingCars = new ArrayList<>();
        for(String carInfo: carInfos) {
            String [] parts = carInfo.split(",");
            racingCars.add(new RacingCar(parts[0], Integer.parseInt(parts[1])));
        }

        // then
        assertThat(findWinner(racingCars)).isEqualTo(expected);
    }
}