package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RandomStrategyTest {

    @DisplayName("랜덤전략 테스트")
    @ParameterizedTest
    @CsvSource(value = {
            "1:False",
            "2:False",
            "3:False",
            "4:False",
            "5:True",
            "6:True",
            "7:True",
            "8:True",
            "9:True",
    }, delimiter = ':')
    public void test(int value, boolean expected) {
        RandomStrategy randomStrategy = new RandomStrategy();
        assertThat(randomStrategy.strategy(value)).isEqualTo(expected);
    }

    @DisplayName("랜덤 전략 테스트 - 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {
            "-1",
            "-2",
            "10"
    })
    public void test2(int value) {
        RandomStrategy randomStrategy = new RandomStrategy();
        assertThatThrownBy(() -> {
                    randomStrategy.strategy(value);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

}
