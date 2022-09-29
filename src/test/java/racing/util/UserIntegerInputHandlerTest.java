package racing.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class UserIntegerInputHandlerTest {
    @ParameterizedTest
    @CsvSource(value = {"-1,false", "3,true"})
    void 음수_양수_판단_테스트(int number, boolean expect) {
        assertThat(new UserIntegerInputHandler().validate(number)).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource(value = {"a,false", "b,false", "1,true"})
    void 문자_숫자_입력테스트(String str, boolean expect) {
        assertThat(new UserIntegerInputHandler().validate(str)).isEqualTo(expect);
    }

    @Test
    void 숫자를_입력했을때_정상() {
        assertThat(new UserIntegerInputHandler().validate(3)).isTrue();
    }

}
