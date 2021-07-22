package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class CountTest {
    @DisplayName("카운트 값이 1보다 작을경우 IllegalArgumentException을 발생시킨다")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void gemeCountException(int count) {
        //given, when, then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Count(count))
                .withMessage("0보다 큰 숫자여야 합니다.");
    }

    @DisplayName("카운트 값이 0 보다 클 경우 Count가 정상 생성된다")
    @Test
    void createCount() {
        //given, when
        Count count = new Count(1);

        //then
        assertThat(count.getCount()).isEqualTo(1);
    }
}