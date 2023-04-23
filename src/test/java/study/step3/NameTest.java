package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.security.InvalidParameterException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @DisplayName("이름의 길이는 5를 초과할 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"longName", "veryLongName", "fives_"})
    public void check_name_length(String name) throws Exception {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(InvalidParameterException.class);

    }
}
