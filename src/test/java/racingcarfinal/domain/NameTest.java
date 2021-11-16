package racingcarfinal.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"A", "pobi1"})
    void create(String inputName) {
        Name name = new Name(inputName);
        assertThat(name).isInstanceOf(Name.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "pobizz"})
    void createFail(String inputName) {
        assertThatThrownBy(() -> {
            new Name(inputName);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 없거나 5자를 초과할 수 없습니다.");
    }

}
