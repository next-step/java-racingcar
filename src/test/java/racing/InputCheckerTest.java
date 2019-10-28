package racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.in;

import java.util.Arrays;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class InputCheckerTest {

    @ParameterizedTest
    @ValueSource(strings = {"a,b,c,", "a,,b", ",a", ""})
    void 자동차이름_유효성_테스트(String input) {
        assertThatIllegalArgumentException().isThrownBy( () -> {
            new InputChecker(input, 4);
        }).withMessage("자동차 이름을 정확히 입력하세요.");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -10})
    void 전진시도회수_유효성_테스트(int tries) {
        assertThatIllegalArgumentException().isThrownBy( () -> {
            new InputChecker("a,b", tries);
        }).withMessage("경주할 거리를 정확히 입력하세요.");
    }

    @ParameterizedTest
    @CsvSource(value = {"a,b,c:2", "a,b,c,d:6", "a:100"}, delimiter = ':')
    void 정상입력_테스트(String input, int tries) {
        InputChecker inputChecker = new InputChecker(input, tries);
        assertThat(inputChecker.getNames()).isEqualTo(Arrays.asList(input.split(",")));
        assertThat(inputChecker.getTries()).isEqualTo(tries);
    }

}