package racingGame;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingGame.exception.NegativeExceptionV1;
import racingGame.view.InputVerifier;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class InputVerifierTest {
    @ParameterizedTest
    @ValueSource(strings = {"-1,-,#, ,&,@,%"})
    void validateInput(String input) {
        assertThrows(NegativeExceptionV1.class, ()
                -> InputVerifier.validateInput(input));
    }
}