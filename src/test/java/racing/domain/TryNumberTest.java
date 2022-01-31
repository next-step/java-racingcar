package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TryNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, -2})
    void tryNumber_유효하지_않은_정수_입력(int tryNumber) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new TryNumber(tryNumber))
            .withMessage("[ERROR] 시도 횟수는 최소 1회 이상이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void 레이싱_진행할_수_있으면_참_반환(int inputNumber) {
        final TryNumber tryNumber = new TryNumber(inputNumber);
        assertThat(tryNumber.hasNextStep()).isTrue();
    }

    @Test
    void 레이싱_진행할_수_없으면_거짓_반환() {
        final TryNumber tryNumber = new TryNumber(1);
        tryNumber.nextStep();
        assertThat(tryNumber.hasNextStep()).isFalse();
    }
}