package step5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step5.domain.Car;
import step5.domain.Racing;
import step5.domain.RacingRule;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class RacingTest {

    @ParameterizedTest
    @CsvSource(value = {" m oon  = moon", "m iha  = miha"}, delimiter = '=')
    void 자동차이름_테스트(String input, String expected) {
        // given & when
        Car car = new Car(input);
        // then
        assertThat(car.getName()).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"   ", " , ,", "", "m o on child, IU", "moonchild, IU"})
    void 자동차이름_예외테스트(String input) {
        // given & when
        Throwable thrown = catchThrowable(() -> {
            new Car(input);
        });
        // then
        Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("0에서 9 사이에서 random 값을 구한다")
    void 랜덤조건확인() {
        // given & when
        int num = new RacingRule().castDice();
        // then
        assertThat(num).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
    }

    @Test
    @DisplayName("자동차는 전진 또는 멈출 수 있다")
    void 자동차_전진() {
        // given & when
        Car car = new Car("moon");
        new RacingRule().go(car);
        // then
        assertThat(car.getPosition()).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("자동차는 4 이상일때만 전진한다.")
    @CsvSource(value = {"4,1", "3,0", "5,1"}, delimiter = ',')
    void 자동차_전진(int dice, int expected) {
        // given & when
        Car car = new Car("IU");
        new RacingRule().go(car, dice);
        // then
        assertThat(car.getPosition()).isEqualTo(expected);
    }

    @Test
    void 우승자구하기() {
        // given
        Car car1 = new Car("IU", 3);
        Car car2 = new Car("moon", 1);
        Car car3 = new Car("shine", 2);
        Car car4 = new Car("miha", 3);

        List<Car> cars = Arrays.asList(car1, car2, car3, car4);

        // when
        String winner = Racing.getWinnersName(cars);

        // then
        assertThat(winner).contains("IU", "miha").doesNotContain("moon", "shine");
    }

}
