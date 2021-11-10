package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step4.domain.Name;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NameTest {

    @DisplayName("이름의 길이는 1자 ~ 5자이다.")
    @ParameterizedTest
    @ValueSource(strings = {"abcdef", ""})
    void nameTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Name(input);
        });
    }

}