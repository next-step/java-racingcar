package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @DisplayName("이름이 limit value 보다 크면 false를 반환한다")
    @Test
    public void should_return_false_name_over_limit_value() throws Exception {
        //arrange
        Player player = new TestablePlayer("aaaaaa");

        //act, assert
        assertFalse(player.isNameAvailable());
    }

    @DisplayName("이름이 limit value 보다 작으면 true를 반환한다")
    @Test
    public void should_return_true_name_under_limit_value() throws Exception {
        //arrange
        Player player = new TestablePlayer("aa");

        //act, assert
        assertTrue(player.isNameAvailable());
    }

    class TestablePlayer extends Player {

        public TestablePlayer(String name) {
            super(name);
        }

        @Override
        protected int getLimitValue() {
            return 5;
        }
    }
}