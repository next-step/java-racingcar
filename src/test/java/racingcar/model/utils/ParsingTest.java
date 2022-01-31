package racingcar.model.utils;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static racingcar.model.utils.common.Parsing.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParsingTest {

    @DisplayName("자동차_입력_테스트")
    @ParameterizedTest
    @ValueSource(strings={"a,aa,aaaaaa"})
    void parsingCarNameTest(String input) {
        assertTrue(parsingCarName(input));
    }

    @DisplayName("자동차_입력_테스트")
    @ParameterizedTest
    @ValueSource(ints = 10)
    void parsingRacingTryTest(int input) {
        assertTrue(racingTryCheck(input));
    }
}
