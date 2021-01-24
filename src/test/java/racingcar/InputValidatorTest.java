package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class InputValidatorTest {

    @DisplayName("잘못된 자동차 이름 입력에 대한 유효성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {",,,", ", , ,", "a, b, ,",",,,,","","     "})
    void wrongCarsNameInputTest(String input) {

        assertThat(InputValidator.checkCarsNameInput(input)).isEqualTo(false);
    }

    @DisplayName("잘못된 라운드 입력에 대한 유효성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"WOW!!", "??", "abc"})
    void wrongRoundNumberInputTest(String input) {

        assertThat(InputValidator.checkRoundNumberInput(input)).isEqualTo(false);
    }
}
