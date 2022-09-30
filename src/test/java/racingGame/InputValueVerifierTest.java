package racingGame;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingGame.exception.WrongInputException;
import racingGame.view.InputVerifier;

import static org.junit.jupiter.api.Assertions.*;

class InputValueVerifierTest {
    @ParameterizedTest
    @ValueSource(strings = {"-1,-,#, ,&,@,%"})
    void validateTryNumInput(String input) {
        assertThrows(WrongInputException.class, ()
                -> InputVerifier.validateTryInput(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {" ,-12,-1,#,$"})
    void validateCarNameInput(String input) {
        assertThrows(WrongInputException.class, ()
                -> InputVerifier.validateNameInput(input));
    }

}