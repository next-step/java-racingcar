package racingcar.model.wrapper;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.CarNumberException;
import racingcar.exception.MovementNumberException;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MovementNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, Integer.MAX_VALUE})
    void 이동_횟수는_최소_1회_이상이다(int number) {
        assertThatNoException().isThrownBy(() -> {
            new MovementNumber(number);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, Integer.MIN_VALUE})
    void 이동_횟수_1회_미만_에러(int number) {
        assertThatThrownBy(() -> {
            new MovementNumber(number);
        }).isInstanceOf(MovementNumberException.class)
                .hasMessage("이동 횟수는 1 이상이어야 합니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {
            "3,4,false",
            "4,3,true",
            "4,4,false",
    })
    void 큰_값인지_여부를_리턴한다(int number, int compare, boolean expected) {
        MovementNumber positiveNumber = new MovementNumber(number);
        boolean actual = positiveNumber.isGreaterThan(compare);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

}
