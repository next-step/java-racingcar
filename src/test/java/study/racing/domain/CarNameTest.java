package study.racing.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarNameTest {

    @Test
    void 자동차_이름을_생성한다() {
        CarName yang = new CarName("yang");
        assertEquals("yang", yang.getValue());
    }

    @Test
    void 자동차의_이름은_5글자까지_생성가능하다() {
        CarName car = new CarName("12345");
        assertEquals("12345", car.getValue());
    }

    @Test
    void 자동차의_이름은_null이_예외가_발생한다() {
        assertThrows(IllegalArgumentException.class, () -> new CarName(null));
    }

    @Test
    void 자동차의_이름은_5자를_초과할수없다() {
        assertThrows(IllegalArgumentException.class, () -> new CarName("yang555"));
    }

    @Test
    void 같은_이름이면_동등성을_가진다() {
        CarName name1 = new CarName("yang");
        CarName name2 = new CarName("yang");
        assertEquals(name1, name2);
    }

}
