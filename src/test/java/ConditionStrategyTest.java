import org.junit.jupiter.api.Test;
import racing.domain.ConditionStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class ConditionStrategyTest {
    @Test
    void moveCondition(){
        ConditionStrategy condition = new ConditionStrategy();
        condition.moveCondition();
        assertThat(condition.getRandomNumber()).isBetween(0, 9);
    }
}