package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.domain.Validator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserInputTest {
    @ValueSource(strings = {"tom, boss,test , abcde, ok,    blank   , a to b"})
    @ParameterizedTest
    void 이름_쉼표로_나누기(String input) {
        assertThat(UserInput.splitStringByComma(input)).containsExactly("tom", "boss", "test", "abcde", "ok", "blank", "a to b");
    }
}