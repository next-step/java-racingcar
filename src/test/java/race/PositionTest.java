package race;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PositionTest {
    @Test
    void position_초기값은_0이다() {
        assertThat(new Position().getPosition()).isEqualTo(0);
    }

    @Test
    void add할_때마다_1이_추가된다() {
        Position position = new Position();

        position.moveForward();
        assertThat(position.getPosition()).isEqualTo(1);

        position.moveForward();
        assertThat(position.getPosition()).isEqualTo(2);
    }

    @Test
    void Position은_int값과_동일한지_비교할_수_있다() {
        Position position = new Position();
        assertThat(position).isEqualTo(0);

        position.moveForward();
        assertThat(position).isEqualTo(1);
    }
}
