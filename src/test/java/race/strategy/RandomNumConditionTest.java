package race.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import race.strategy.MoveCondition;
import race.strategy.RandomNumCondition;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumConditionTest {

    @Test
    @DisplayName("moveOrNot 테스트")
    void moveOrNotTest() {
        MoveCondition moveCondition = new RandomNumCondition() {
            @Override
            public boolean moveOrNot() {
                return true;
            }
        };
        assertThat(moveCondition.moveOrNot()).isTrue();
    }

}