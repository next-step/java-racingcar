package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RandomNumberTest {

    @Test
    void valid() {
        assertThatIllegalArgumentException().isThrownBy(() -> new RandomNumber(10));
    }

    @Test
    void create() {
        RandomNumber rn = new RandomNumber(4);
        assertThat(rn).isEqualTo(new RandomNumber(4));
    }

    @Test
    void isAdvancedConditionFalse() {
        RandomNumber rn = new RandomNumber(3);
        boolean isAdvancedCondition = rn.isAdvancedCondition();
        assertThat(isAdvancedCondition).isEqualTo(false);
    }

    @Test
    void isAdvancedConditionTrue() {
        RandomNumber rn = new RandomNumber(4);
        boolean isAdvancedCondition = rn.isAdvancedCondition();
        assertThat(isAdvancedCondition).isEqualTo(true);
    }

}
