package racingcar.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class NameTest {
    @ParameterizedTest
    @CsvSource(value = {"tomo:tomo"}, delimiter = ':')
    void testTheSameCarNames(String input, String expected) {
        Name inputName = new Name(input);
        Name expectedName = new Name(expected);

        assertThat(inputName.equals(expectedName)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"tomo:pobi", "tomo:mike"}, delimiter = ':')
    void testDifferentCarNames(String input, String expected) {
        Name inputName = new Name(input);
        Name expectedName = new Name(expected);

        assertThat(inputName.equals(expectedName)).isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {"tomotomo", "michael", "lastzedai"})
    void testNameLengthGreaterThanFive(String input) {
        assertThatThrownBy(() -> new Name(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
