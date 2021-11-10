package race;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {
    @ParameterizedTest
    @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
    void create_successful(String rawName) {
        CarName carName = new CarName(rawName);
        assertThat(carName.toString()).isEqualTo(rawName);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a ", "ab ", "abc ", "abcd ", "abcde "})
    void trim(String rawName) {
        CarName carName = new CarName(rawName);
        assertThat(carName.toString()).isEqualTo(rawName.trim());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void invalidName_blank(String name) {
        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "abcdefff"})
    void invalidName_tooLong(String name) {
        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void invalidName_null() {
        assertThatThrownBy(() -> new CarName(null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}