package study.racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class RandomValueTest {
    @DisplayName("랜덤값 동일 확인")
    @ParameterizedTest(name="{displayName} | 요청값: {0}")
    @ValueSource(ints = {1, 9, 4})
    void 랜덤값_동일(int param) {
        assertThat(new RandomValue(param)).isEqualTo(new RandomValue(param));
    }

    @DisplayName("랜덤값 유효성 확인")
    @ParameterizedTest(name="{displayName} | 요청값: {0}")
    @ValueSource(ints = {-1, 0, 10, 99})
    void 랜덤값_유효성(int param) {
        assertThatThrownBy(() -> {
            assertThat(new RandomValue(param));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("랜덤값 이동가능 확인")
    @ParameterizedTest(name="{displayName} | 요청값: {0}")
    @ValueSource(ints = {5,9,7})
    void 랜덤값_이동가능(int param) {
        assertThat(new RandomValue(param).isMovable()).isTrue();
    }

    @DisplayName("랜덤값 이동불가 확인")
    @ParameterizedTest(name="{displayName} | 요청값: {0}")
    @ValueSource(ints = {1,2,3})
    void 랜덤값_이동불가(int param) {
        assertThat(new RandomValue(param).isMovable()).isFalse();
    }
}
