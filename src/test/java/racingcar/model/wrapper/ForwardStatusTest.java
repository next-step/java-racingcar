package racingcar.model.wrapper;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.ForwardStatusException;
import racingcar.model.enums.Status;

import static org.assertj.core.api.Assertions.*;
import static racingcar.model.enums.Status.FORWARD;
import static racingcar.model.enums.Status.STOP;

public class ForwardStatusTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    void 동등_비교(int number) {
        ForwardStatus actual = new ForwardStatus(number);
        ForwardStatus expected = new ForwardStatus(number);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    void number_값은_0_9_사이이다(int number) {
        assertThatNoException().isThrownBy(() -> {
            new ForwardStatus(number);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, Integer.MIN_VALUE, 10, Integer.MAX_VALUE})
    void number_값은_0미만_9초과시_에러(int number) {
        assertThatThrownBy(() -> {
            new ForwardStatus(number);
        }).isInstanceOf(ForwardStatusException.class)
                .hasMessage("0~9 사이의 숫자 외에는 전진숫자로 허용되지 않습니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void number_값이_4_이상일_경우_전진한다(int number) {
        // given
        ForwardStatus forwardStatus = new ForwardStatus(number);

        // when
        Status actual = forwardStatus.status();

        // then
        assertThat(actual).isEqualTo(FORWARD);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void number_값이_4_미만일_경우_멈춘다(int number) {
        // given
        ForwardStatus forwardStatus = new ForwardStatus(number);

        // when
        Status actual = forwardStatus.status();

        // then
        assertThat(actual).isEqualTo(STOP);
    }
}
