package study.racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarNameTest {

    @Test
    void 자동차_이름을_생성한다() {
        CarName yang = new CarName("yang");
        assertThat(yang.getValue()).isEqualTo("yang");
    }

    @Test
    void 자동차의_이름은_5글자까지_생성가능하다() {
        CarName car = new CarName("12345");
        assertThat(car.getValue()).isEqualTo("12345");
    }

    @Test
    void 자동차의_이름은_null이_예외가_발생한다() {
        assertThrows(IllegalArgumentException.class, () -> new CarName(null));
    }

    @Test
    void 자동차의_이름은_5자를_초과할수없다() {
        assertThatThrownBy(() -> new CarName("1234567"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 최대 5글자를 초과할 수 없습니다.");
    }

    @Test
    void 같은_이름이면_동등성을_가진다() {
        CarName name1 = new CarName("yang");
        CarName name2 = new CarName("yang");
        assertEquals(name1, name2);
        assertThat(name1).isEqualTo(name2);
    }

}
