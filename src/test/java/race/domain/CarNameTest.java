package race.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {
    @ParameterizedTest
    @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
    void create_successful(String rawName) {
        CarName carName = new CarName(rawName);
        assertThat(carName).isEqualTo(new CarName(rawName));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a ", "ab ", "abc ", "abcd ", "abcde "})
    void trim(String rawName) {
        CarName carName = new CarName(rawName);
        assertThat(carName).isEqualTo(new CarName(rawName.trim()));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "abcdefff"})
    void invalidName_tooLong(String name) {
        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void invalidName_nullAndEmpty(String name) {
        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void invalidName_notEmptyButBlank() {
        assertThatThrownBy(() -> new CarName(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
