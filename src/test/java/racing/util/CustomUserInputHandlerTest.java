package racing.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.util.CustomUserInputHandler;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CustomUserInputHandlerTest {
    @ParameterizedTest
    @CsvSource(value = {"-1,false", "3,true"})
    void 음수_양수_판단_테스트(int number, boolean expect) {
        assertThat(CustomUserInputHandler.validate(number)).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource(value = {"a,false", "b,false"})
    void 문자_숫자_입력테스트(String str, boolean expect) {
        assertThat(CustomUserInputHandler.validate(str)).isEqualTo(expect);
    }

    @Test
    void 숫자를_입력했을때_정상() {
        assertThat(CustomUserInputHandler.validate(3)).isTrue();
    }

}
