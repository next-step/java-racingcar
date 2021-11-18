package racingcargamefinal.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"A", "pobiz"})
    void create(String carName) {
        assertDoesNotThrow(() -> {
            new Name(carName);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "pobizz"})
    void createFail(String carName) {
        assertThatThrownBy(() -> {
            new Name(carName);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 없거나 5자를 초과할 수 없습니다.");
    }

}
