package step2;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

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

    @Test
    void Given_Negative_When_Created_Then_ThrowError() {
        assertThatThrownBy(() -> new Positive("-1"))
                .isInstanceOf(RuntimeException.class);
    }
}
