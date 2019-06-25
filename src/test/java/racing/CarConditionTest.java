package racing;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarConditionTest {

    @Test
    @RepeatedTest(10)
    void getCondition() {
        assertThat(CarCondition.get()).isBetween(0, 9);
    }
}
