package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcarver2.validator.InputStringValidator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {


    @DisplayName("숫자 입력값 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"-34", ":1\\2345"})
    void enterInputTest(String input) {
        assertThatThrownBy(() -> {
            InputStringValidator.valid(input);
        }).isInstanceOf(RuntimeException.class);
    }


}
