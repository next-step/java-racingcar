package step3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.domain.movingstrategy.InputMovingStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class InputMovingStrategyTest {
    @ParameterizedTest
    @CsvSource(
            value = {"0,false", "1,false", "2,false", "3,false", "4,true", "5,true", "6,true", "7,true", "8,true", "9,true"}
    )
    void run(int input, boolean expected) {
        InputMovingStrategy strategy = new InputMovingStrategy(input);
        assertThat(strategy.run()).isEqualTo(expected);
    }
}