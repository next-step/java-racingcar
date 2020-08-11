package cc.oakk.racing.model.predicate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RangePredicateTest {
    @ParameterizedTest
    @CsvSource(value = {"0:4:2", "0:10:5", "0:0:0", "-5:10:-2"}, delimiter = ':')
    @DisplayName("주어진 값이 범위 내에 있을 때")
    public void isMeetCondition_ReturnTrue(int min, int max, int source) {
        Predicate<Integer> predicate = createRangeCondition(min, max);
        assertThat(predicate.test(source)).isEqualTo(true);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:4:7", "0:10:-4", "0:0:1", "-5:10:-10"}, delimiter = ':')
    @DisplayName("주어진 값이 범위 내에 없을 때")
    public void isMeetCondition_ReturnFalse(int min, int max, int source) {
        Predicate<Integer> predicate = createRangeCondition(min, max);
        assertThat(predicate.test(source)).isEqualTo(false);
    }

    @Test
    @DisplayName("주어진 값이 null 일 때 예외발생")
    public void isMeetCondition_ShouldThrow_IllegalArgumentException_OnNull() {
        Predicate<Integer> predicate = createRangeCondition(0, 0);
        assertThatIllegalArgumentException().isThrownBy(() -> predicate.test(null));
    }

    @Test
    @DisplayName("min이 max 보다 클 때 예외발생")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void isMeetCondition_ShouldThrow_IllegalArgumentException_OnMinIsGreaterThanMax() {
        assertThatIllegalArgumentException().isThrownBy(() -> createRangeCondition(10, -5));
    }

    private RangePredicate createRangeCondition(int min, int max) {
        return new RangePredicate(min, max);
    }
}
