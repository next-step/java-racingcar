package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNumberTest {
    @Test
    void max() {
        CarNumber number = new CarNumber(1);
        assertThat(number.max(2)).isEqualTo(new CarNumber(2));
        assertThat(number.max(new CarNumber(3))).isEqualTo(new CarNumber(3));
    }

    @Test
    void 증가_감소() {
        CarNumber number1 = new CarNumber(1);
        number1.increase();
        assertThat(number1).isEqualTo(new CarNumber(2));

        CarNumber number2 = new CarNumber(2);
        number2.decrease();
        assertThat(number2).isEqualTo(new CarNumber(1));
    }

    @Test
    void create() {
        assertThat(new CarNumber(1)).isEqualTo(new CarNumber(1));

        assertThatThrownBy(() -> {
            new CarNumber(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
