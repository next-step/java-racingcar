package racing.domain;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void nameValidationErrorTest(String initName) {
        assertThatThrownBy(() -> new Name(initName)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"123,123", "123455,12345", "12345,12345"})
    public void nameValidationTest(String initName, String expectedName) {
        Name name = new Name(initName);
        assertThat(name.toString()).isEqualTo(expectedName);
    }

}