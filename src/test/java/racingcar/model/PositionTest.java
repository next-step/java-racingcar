package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {
    private Position position;

    @BeforeEach
    void setUp() {
        this.position = new Position(2);
    }

    @Nested
    class increase_메서드는 {

        @Test
        void 증가된_Position값을_리턴한다() {
            Position actual = position.increase();

            assertThat(actual).isEqualTo(new Position(3));
        }
    }

    @Nested
    class toString_메서드는 {

        @Test
        void 포지션만큼의_막대기_문자열을_리턴한다() {
            String string = position.toString();

            assertThat(string).isEqualTo("--");
        }
    }

    @Nested
    class getPosition_메서드는 {

        @Test
        void 현재_포지션을_리턴한다() {
            assertThat(position.getPosition()).isEqualTo(2);
        }
    }
}
