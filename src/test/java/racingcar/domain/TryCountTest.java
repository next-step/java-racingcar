package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.TryCountInputException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class TryCountTest {

    @Test
    @DisplayName("시도횟수를 생성한다.")
    void tryCountTest_create() {
        assertDoesNotThrow(() -> new TryCount("1"));
    }

    @Test
    @DisplayName("음수의 시도횟수는 예외를 던진다.")
    void tryCountTest_negative() {
        assertThatThrownBy(() -> new TryCount("-1"))
                .isInstanceOf(TryCountInputException.class);
    }

    @Test
    @DisplayName("게임을 진행 시 시도횟수가 1 감소한다.")
    void tryCountTest_decreaseTryCount() {
        TryCount beforeTryCount = new TryCount(1);

        TryCount tryCount = beforeTryCount.decrease();

        assertThat(tryCount.isZero()).isTrue();
    }

}
