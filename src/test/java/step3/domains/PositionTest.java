package step3.domains;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class PositionTest {
    @Test
    void Given_Negative_When_CreatePosition_Then_Failed() {
        assertThatThrownBy(() -> new Position(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    void Given_Zero_Or_Positive_When_CreatePosition_Then_Success(int number) {
        assertThatNoException().isThrownBy(() -> new Position(number));
    }

    @Test
    void Given_Position_When_Increment_Then_Diff_Is_1() {
        Position position = new Position(0);

        Position newPosition = position.incrementAndGet();

        assertThat(newPosition).isEqualTo(new Position(1));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "0,1,true",
            "1,1,true",
            "2,1,false"
    })
    void Given_Two_Position_When_GreaterOrEquals_Then_Success(int smaller, int bigger,
            boolean expected) {
        Position position1 = new Position(smaller);
        Position position2 = new Position(bigger);

        assertThat(position2.isGreaterOrEquals(position1)).isEqualTo(expected);
    }
}
