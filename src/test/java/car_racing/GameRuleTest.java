package car_racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameRuleTest {
    @Test
    public void isGoStraight_4이상은직진이다() {
        Assertions.assertThat(GameRule.isGoStraight(1)).isFalse();
        Assertions.assertThat(GameRule.isGoStraight(5)).isTrue();
    }
}
