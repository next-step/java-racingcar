package step2;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PositiveTest {
    @Test
    void Given_ValidValue_When_CreatePositive_Then_Created() {
        assertThat(new Positive("1")).isEqualTo(new Positive(1));
    }

    @Test
    void Given_Positive_When_Plus_Then_Plus_Two_Number() {
        Positive positive = new Positive("1");

        Positive result = positive.plus(new Positive(2));

        assertThat(result).isEqualTo(new Positive(3));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "a"})
    void Given_InvalidString_When_Created_Then_ThrowError(String input) {
        assertThatThrownBy(() -> new Positive(input))
                .isInstanceOf(RuntimeException.class);
    }
}
