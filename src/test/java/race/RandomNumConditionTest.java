package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumConditionTest {

    @Test
    @DisplayName("moveOrNot 테스트")
    void moveOrNotTest() {
        MoveCondition moveCondition = new RandomNumCondition() {
            @Override
            public int getValue() {
                return 1;
            }

            @Override
            public boolean moveOrNot() {
                return true;
            }
        };
        assertThat(moveCondition.moveOrNot()).isTrue();
    }

}