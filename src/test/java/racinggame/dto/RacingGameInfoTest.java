package racinggame.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class RacingGameInfoTest {

    static Stream<Arguments> racingGameInfo() {
        return Stream.of(
                Arguments.of("가, 나", "0", "시도횟수는 0보다 커야합니다"),
                Arguments.of("가", "-1", "시도횟수는 0보다 커야합니다"),
                Arguments.of("가, 나, 다", "문자", "시도횟수는 숫자로 입력해야합니다. : 문자")
        );
    }

    @DisplayName("시도횟수는 0보다 큰 숫자를 입력하지 않으면 Exception을 던진다")
    @MethodSource("racingGameInfo")
    @ParameterizedTest
    void wrongInput(String participantsCar, String numberOfAttempt, String expectedErrorMessage) {
        assertThatThrownBy(() -> new RacingGameInfo(participantsCar, numberOfAttempt))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedErrorMessage);
    }

}
