package racewinner.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @Test
    void create() {
        Name name = new Name("popo");

        assertThat(name).isEqualTo(new Name("popo"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void nameNullOrEmpty(String input) {
        assertThatThrownBy(() -> new Name(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("자동차 이름은 5글자를 초과하면 IllegalArgumentException 예외가 발생한다.")
    @Test
    void nameTooLong() {
        assertThatThrownBy(() -> new Name("abcdef"))
                .isInstanceOf(IllegalArgumentException.class);
    }


}