package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TryNumberTest {

    @ParameterizedTest
    @ValueSource(strings= {"1", "2", "3"})
    void tryNumber_정수로_형변환_정상_작동(String tryNumber) {
        assertThat(new TryNumber(tryNumber).getTryNumber()).isEqualTo(Integer.parseInt(tryNumber));
    }

    @ParameterizedTest
    @ValueSource(strings= {"-1", "0", "-2"})
    void tryNumber_유효하지_않은_정수_입력(String tryNumber) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new TryNumber(tryNumber).getTryNumber()).withMessage("[ERROR] 시도 횟수는 최소 1회 이상이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings= {"1회", "asdf", "한번돌아라"})
    void tryNumber_형변환_불가(String tryNumber) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new TryNumber(tryNumber).getTryNumber()).withMessage("[ERROR] 숫자만 입력 해주세요.");
    }
}