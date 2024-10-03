package step3.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MovementTest {

    @Test
    void 자동차_움직임_수치_객체_생성() {
        assertThat(new Movement().getMoveCount()).isEqualTo(0);
    }

    @Test
    void 자동차_전진_확인() {
        Movement movement = new Movement();
        movement.move();
        assertThat(movement.getMoveCount()).isEqualTo(1);
    }
}
