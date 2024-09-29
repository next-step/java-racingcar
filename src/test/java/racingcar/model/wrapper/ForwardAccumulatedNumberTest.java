package racingcar.model.wrapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.ForwardAccumulatedNumberException;

import static org.assertj.core.api.Assertions.*;

public class ForwardAccumulatedNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7,8,9})
    void 동등_비교(int number) {
        ForwardAccumulatedNumber actual = new ForwardAccumulatedNumber(number);
        ForwardAccumulatedNumber expected = new ForwardAccumulatedNumber(number);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, Integer.MIN_VALUE})
    void 전진_누적_숫자는_0_미만이면_에러(int number) {
        assertThatThrownBy(() -> {
            new ForwardAccumulatedNumber(number);
        }).isInstanceOf(ForwardAccumulatedNumberException.class)
                .hasMessage("음수는 올 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, Integer.MAX_VALUE})
    void 전진_누적_숫자는_0_이상이다(int number) {
        assertThatNoException().isThrownBy(() -> {
            new ForwardAccumulatedNumber(number);
        });
    }
}
