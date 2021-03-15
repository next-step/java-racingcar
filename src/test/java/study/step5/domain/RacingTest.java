package study.step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RacingTest {

    @DisplayName("Exception 테스트, 시도횟수 입력 오류")
    @ParameterizedTest
    @CsvSource(value = {"yunho,pobi:0", "yunho,pobi:-1"}, delimiter = ':')
    void carNameLengthOver(String carNames, int attemptNumber) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Racing racing = Racing.of(Cars.of(carNames.split(",")), attemptNumber);
        }).withMessage("시도횟수는 최소 1회 이상이어야 합니다.");
    }
}
