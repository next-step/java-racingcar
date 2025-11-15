package study.racing.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TorqueTest {

    @Test
    void 토크를_생성한다() {
        Torque torque = new Torque(5);
        assertEquals(5, torque.getValue());
    }

    @Test
    void 토크가_4이상이면_이동할수있다() {
        Torque torque = new Torque(4);
        assertTrue(torque.isMovable());
    }

    @Test
    void 토크가_3미만이면_이동할수없다() {
        Torque torque = new Torque(3);
        assertFalse(torque.isMovable());
    }

    @Test
    void 토크는_음수이거나_9를초과하면_예외가발생한다() {
        assertThrows(IllegalArgumentException.class, () -> new Torque(-1));
        assertThrows(IllegalArgumentException.class, () -> new Torque(10));
    }


    @Test
    void 같은_토크이면_동등성을_가진다() {
        Torque torque1 = new Torque(5);
        Torque torque2 = new Torque(5);

        assertEquals(torque1, torque2);
    }
}
