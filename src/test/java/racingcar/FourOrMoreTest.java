package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class FourOrMoreTest {
    private FourOrMore strategy;

    @BeforeEach
    void setUp() {
        strategy = new FourOrMore();
    }

    @ParameterizedTest
    @CsvSource(value = {"3:false", "4:true", "5:true"}, delimiter = ':')
    @DisplayName("숫자가 4 이상이면 참, 아니면 거짓을 반환한다.")
    void move_forward(int input, boolean expected) {
        assertThat(strategy.isForward(input)).isEqualTo(expected);
    }
}
