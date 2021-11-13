package step3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class MovingStrategyTest {
    @Test
    @CsvSource(
            value = {"0,false", "1,false", "2,false", "3,false", "4,true", "5,true", "6,true", "7,true", "8,true", "9,true"}
    )
    void run(int input, int expected) {
        MovingStrategy strategy = new MovingStrategy();
        assertThat(strategy.run(input)).isEqualTo(expected);
    }
}