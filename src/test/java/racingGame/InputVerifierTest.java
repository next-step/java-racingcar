package racingGame;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingGame.exception.NegativeExceptionV1;
import racingGame.view.InputVerifier;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class InputVerifierTest {
    private static Stream<Arguments> provideWrongInput() {
        return Stream.of(
                Arguments.of("-1", "1"),
                Arguments.of("*", "1"),
                Arguments.of("&", "1"),
                Arguments.of("1", "&"),
                Arguments.of("1", "-"));
    }

    @ParameterizedTest
    @MethodSource("provideWrongInput")
    void validateInput(String carNum, String tryNum) {
        assertThrows(NegativeExceptionV1.class, ()
                -> InputVerifier.validateInput(carNum, tryNum));
    }
}