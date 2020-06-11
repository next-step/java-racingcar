package step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RoundTest {

    @DisplayName("round가 0보다 작을 경우 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(ints = {0,-1})
    void invalidRound(int initialRound) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Round(initialRound));
    }


}