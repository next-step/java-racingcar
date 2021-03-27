package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class RacingTest {

    @ParameterizedTest
    @CsvSource(value = {"3,5,5", "5,10,10"}, delimiter = ',')
    void 횟수_테스트(int carCount, int lapCount, int expected) {
        // give & when
        Racing racing = new Racing(carCount, lapCount);
        int result = racing.print.getCount();
        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 예외입력_테스트() {
        assertThatThrownBy(() -> {
            new InputPrint().getCarCount();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("0에서 9 사이에서 random 값을 구한다")
    void 랜덤조건확인() {
        int num = new RacingRule().castDice();
        assertThat(num).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
    }

    @Test
    @DisplayName("자동차는 전진 또는 멈출 수 있다")
    void 자동차_전진() {
        Car car = new Car();
        new RacingRule().go(car);
        assertThat(car.getPosition()).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(1);
    }

}
