package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.strategies.CustomRandomImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CustomRandomImplTest {

    @DisplayName("경계값인 1, 10 범위를 반복 테스트")
    @RepeatedTest(10)
    void testRandomRange() {
        int boundOne = 1;
        int boundTen = 10;
        assertThat(new CustomRandomImpl().getRandomRange(boundOne)).isBetween(0, 0);
        assertThat(new CustomRandomImpl().getRandomRange(boundTen)).isBetween(0, 9);
    }

    @DisplayName("랜덤 생성시 0이하 범위는 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void testRandomRangeThrowException(int bound) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new CustomRandomImpl().getRandomRange(bound));
    }
}