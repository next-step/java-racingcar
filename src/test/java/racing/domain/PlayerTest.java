package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @DisplayName("이름이 limit value 보다 크면 CarNameException가 발생한다")
    @Test
    public void should_return_false_name_over_limit_value() throws Exception {
        //arrange, act, assert
        assertThatExceptionOfType(CarNameException.class).isThrownBy(() -> {
            new TestablePlayer("aaaaaa");
        });
    }

    @DisplayName("이름이 limit value 보다 작으면 CarNameException가 발생하지않는다.")
    @Test
    public void should_return_true_name_under_limit_value() throws Exception {
        //arrange, act, assert
        assertAll(
                () -> assertDoesNotThrow(() -> new TestablePlayer("aa")),
                () -> assertEquals(new TestablePlayer("aa").getName(), "aa")
        );
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