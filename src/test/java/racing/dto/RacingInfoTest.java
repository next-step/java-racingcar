package racing.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static racing.dto.RacingInfo.*;

class RacingInfoTest {

    @ParameterizedTest(name = "RacingInfo 정상 생성. (carCount={0}, attempts={1})")
    @CsvSource({
            "6,3",
            "2,2",
            "3,1"
    })
    void of(int carCount, int attempts) {

        RacingInfo racingInfo = RacingInfo.of(carCount, attempts);

        assertThat(racingInfo.getCarCount()).isEqualTo(carCount);
        assertThat(racingInfo.getAttempts()).isEqualTo(attempts);
    }

    @Test
    @DisplayName("차량 개수가 유효하지 않으면 IllegalArgumentException 발생")
    void ofIllegalArgumentExceptionByCarCount() {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> RacingInfo.of(VALID_CAR_COUNT - 1, 5))
                .withMessage(CAR_COUNT_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("시도 횟수가 유효하지 않으면 IllegalArgumentException 발생")
    void ofIllegalArgumentExceptionByAttempts() {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> RacingInfo.of(5, VALID_ATTEMPTS - 1))
                .withMessage(ATTEMPTS_EXCEPTION_MESSAGE);
    }
}