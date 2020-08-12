package cc.oakk.racing.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RoundCountTest {
    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3, 4, 5 })
    void increase(int totalRoundCount) {
        RoundCount roundCount = new RoundCount(totalRoundCount);
        for (int i = 0; i < totalRoundCount; i++) {
            roundCount.increase();
        }
        assertThatThrownBy(roundCount::increase).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
