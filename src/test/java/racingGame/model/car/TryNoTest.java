package racingGame.model.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.function.Try;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TryNoTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("생성자는 입력이 유효한 경우, 객체를 반환한다.")
    void 생성자_성공_테스트(final int number) {
        TryNo expected = new TryNo(number);

        assertThat(expected.getTryNo()).isEqualTo(number);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("생성자는 입력이 유효하지 않으면, 에러를 반환한다.")
    void 생성자_실패_테스트(final int number) {
        assertThatThrownBy(() -> new TryNo(number))
        .isInstanceOf(RuntimeException.class);
    }
}
