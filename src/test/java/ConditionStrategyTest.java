import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ConditionStrategyTest {
    @Test
    void moveCondition(){
        ConditionStrategy condition = new ConditionStrategy();
        condition.moveCondition();
        assertThat(condition.getRandomNumber()).isBetween(0, 9);
    }
}