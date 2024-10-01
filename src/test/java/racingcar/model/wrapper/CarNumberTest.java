package racingcar.model.wrapper;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.CarNumberException;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void 자동차_대수는_최소_1대_이상이다(int number) {
        assertThatNoException().isThrownBy(() -> {
            CarNumber carNumber = new CarNumber(number);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, Integer.MIN_VALUE})
    void 자동차_대수_1대_미만이면_오류(int number) {
        assertThatThrownBy(() -> {
            CarNumber carNumber = new CarNumber(number);
        }).isInstanceOf(CarNumberException.class)
                .hasMessage("자동차 대수는 1대 이상이어야 합니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {
            "3,4,false",
            "4,3,true",
            "4,4,false",
    })
    void 큰_값인지_여부를_리턴한다(int number, int compare, boolean expected) {
        CarNumber carNumber = new CarNumber(number);
        boolean actual = carNumber.isGreaterThan(compare);
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
