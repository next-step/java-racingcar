package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.util.ValidateUtils;

class ValidateUtilsTest {

    private ValidateUtils validateUtils = new ValidateUtils();

    @ParameterizedTest
    @MethodSource("provideStringArrayForIsValidateSource")
    void validateCarName(String[] carArray, boolean expected) {
        assertEquals(expected, validateUtils.validateCarName(carArray));
    }

    @Test
    void validGameCntInput() {
        assertThat(validateUtils.validGameCntInput("123")).isTrue();
        assertThat(validateUtils.validGameCntInput("dgdsgsd")).isFalse();
        assertThat(validateUtils.validGameCntInput("")).isFalse();
    }

    private static Stream<Arguments> provideStringArrayForIsValidateSource() {
        return Stream.of(
            Arguments.of(new String[]{" ", " ", " "}, false),
            Arguments.of(new String[]{"123456", "123", "112"}, false),
            Arguments.of(new String[]{"12345", "123", "112"}, true)
        );
    }

}
