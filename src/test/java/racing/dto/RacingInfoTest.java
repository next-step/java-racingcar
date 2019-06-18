package racing.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static racing.dto.RacingInfo.*;

class RacingInfoTest {

    @ParameterizedTest(name = "RacingInfo 정상 생성 (carNames={0}, attempts={1})")
    @MethodSource
    void of(List<String> carNames, int attempts) {

        RacingInfo racingInfo = RacingInfo.of(carNames, attempts);

        assertThat(racingInfo.getCarNames()).containsExactly(carNames.toArray(new String[0]));
        assertThat(racingInfo.getAttempts()).isEqualTo(attempts);
    }

    @Test
    @DisplayName("차량이름 수가 유효하지 않으면 IllegalArgumentException 발생")
    void ofIllegalArgumentExceptionByCarCount() {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> RacingInfo.of(Collections.emptyList(), 5))
                .withMessage(CAR_NAMES_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("시도 횟수가 유효하지 않으면 IllegalArgumentException 발생")
    void ofIllegalArgumentExceptionByAttempts() {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> RacingInfo.of(Arrays.asList("pobi", "crong", "honux"), VALID_ATTEMPTS - 1))
                .withMessage(ATTEMPTS_EXCEPTION_MESSAGE);
    }

    private static Stream<Arguments> of() {

        return Stream.of(
                Arguments.of(Arrays.asList("pobi", "crong", "honux"), 6),
                Arguments.of(Arrays.asList("pobi", "crong", "honux"), 3),
                Arguments.of(Arrays.asList("pobi", "crong", "honux"), 99),
                Arguments.of(Arrays.asList("pobi", "crong"), 2),
                Arguments.of(Arrays.asList("pobi"), 1)
        );
    }
}