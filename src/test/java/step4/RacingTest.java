package step4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static step4.InputPrint.getSplitInputs;

class RacingTest {

    @Test
    void 이름입력_테스트() {
        // given & when
        String[] names = getSplitInputs("moon ,child, IU, ");
        String[] expect = {"moon", "child", "IU"};
        // then
        assertThat(names).isEqualTo(expect);
    }

    @ParameterizedTest
    @ValueSource(strings = {"   ", " , ,", "", "moonchild, IU"})
    void 이름_예외테스트(String input) {
        // given & when
        Throwable thrown = catchThrowable(() -> {
            getSplitInputs(input);
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
        RacingRule rule = new RacingRule();
        List<Car> cars = new ArrayList<>();

        Car car1 = new Car("IU");
        rule.go(car1, 4);
        rule.go(car1, 4);
        Car car2 = new Car("moon");
        rule.go(car2, 1);
        Car car3 = new Car("shine");
        rule.go(car3, 1);
        Car car4 = new Car("miha");
        rule.go(car4, 4);
        rule.go(car4, 4);

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);

        // when
        String winner = Racing.getWinnersName(cars);

        // then
        assertThat(winner).contains("IU", "miha").doesNotContain("monn","shine");
    }

}
