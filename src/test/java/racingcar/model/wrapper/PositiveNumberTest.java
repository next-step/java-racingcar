package racingcar.model.wrapper;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.PositiveNumberException;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositiveNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, Integer.MAX_VALUE})
    void 양수를_만든다(int number) {
        assertThatNoException().isThrownBy(() -> {
            new PositiveNumber(number);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, Integer.MIN_VALUE})
    void 음수_입력시_에러(int number) {
        assertThatThrownBy(() -> {
            new PositiveNumber(number);
        }).isInstanceOf(PositiveNumberException.class)
                .hasMessage("음수는 입력될 수 없습니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {
            "3,4,false",
            "4,3,true",
            "4,4,false",
    })
    void 큰_값인지_여부를_리턴한다(int number, int compare, boolean expected) {
        PositiveNumber positiveNumber = new PositiveNumber(number);
        boolean actual = positiveNumber.isGreaterThan(compare);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

}
