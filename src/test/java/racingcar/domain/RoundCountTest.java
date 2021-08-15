package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RoundCountTest {

    @DisplayName("생성")
    @Test
    void create() {
        RoundCount roundCount = new RoundCount(5);
        assertThat(roundCount).isEqualTo(new RoundCount(5));
    }

    @DisplayName("1보다 작은 수일 경우 IllegalArgumentException 발생")
    @ParameterizedTest(name = "{index}. {displayName}, arguments: {arguments}")
    @ValueSource(ints = {0, -1})
    void create_ThrowsIllegalArgumentException_IfInputNumberLessThanOne(int input) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new RoundCount(input));
    }
}
