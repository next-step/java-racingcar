package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomMoveStrategyTest {

    @DisplayName("랜덤하게 true 와 false가 나온다.")
    @Test
    void randomTest() {
        MoveStrategy moveStrategy = new RandomMoveStrategy();

        for(int i = 0; i < 10; i++) {
            System.out.println("moveStrategy = " + moveStrategy.test());
        }
    }

}